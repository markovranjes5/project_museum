package com.example.project_museum.controllers;

import com.example.project_museum.models.requests.VirtualTicketRequest;
import com.example.project_museum.models.entities.*;
import com.example.project_museum.repositories.*;
import com.example.project_museum.services.EmailService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/virtual-tickets")
public class VirtualTicketController {

    private final VirtualTicketEntityRepository virtualTicketEntityRepository;
    private final CreditCardEntityRepository creditCardEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final VirtualVisitEntityRepository virtualVisitEntityRepository;
    private final MuseumEntityRepository museumEntityRepository;
    private final EmailService emailService;

    public VirtualTicketController(VirtualTicketEntityRepository virtualTicketEntityRepository, CreditCardEntityRepository creditCardEntityRepository, TransactionEntityRepository transactionEntityRepository, UserEntityRepository userEntityRepository, VirtualVisitEntityRepository virtualVisitEntityRepository, MuseumEntityRepository museumEntityRepository, EmailService emailService){
        this.virtualTicketEntityRepository = virtualTicketEntityRepository;
        this.creditCardEntityRepository = creditCardEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.userEntityRepository = userEntityRepository;
        this.virtualVisitEntityRepository = virtualVisitEntityRepository;
        this.museumEntityRepository = museumEntityRepository;
        this.emailService = emailService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<VirtualTicketEntity> findAll(){
        return virtualTicketEntityRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity insert(@RequestBody VirtualTicketRequest virtualTicketRequest){
        List<CreditCardEntity> creditCardEntities = creditCardEntityRepository.verifyCard(virtualTicketRequest.getCard_number(),virtualTicketRequest.getPin(),
                virtualTicketRequest.getExpiration_date(), virtualTicketRequest.getType(), virtualTicketRequest.getFirstname(), virtualTicketRequest.getLastname());
        if(creditCardEntities.isEmpty())
            return ResponseEntity.status(403).body("Wrong credentials.");
        CreditCardEntity creditCardEntity = creditCardEntities.get(0);

        if(creditCardEntity.getBlocked().equals('1'))
        {
            System.out.println("Blocked.");
            return ResponseEntity.status(403).body("Card is blocked.");


        }
        if(creditCardEntity.getBalance().compareTo(BigDecimal.valueOf(virtualTicketRequest.getPrice()))<0)
            return ResponseEntity.status(403).body("Not enough money.");
        VirtualTicketEntity virtualTicketEntity = virtualTicketEntityRepository.save(new VirtualTicketEntity(virtualTicketRequest.getUser_id(),
                virtualTicketRequest.getVirtual_visit_id()));
        transactionEntityRepository.save(new TransactionEntity(new TransactionEntityId(virtualTicketEntity.getId(),virtualTicketRequest.getCard_number()),
                creditCardEntity.getBalance(), creditCardEntity.getBalance().subtract(BigDecimal.valueOf(virtualTicketRequest.getPrice())), Instant.now()));
        creditCardEntity.setBalance(creditCardEntity.getBalance().subtract(BigDecimal.valueOf(virtualTicketRequest.getPrice())));
        creditCardEntityRepository.save(creditCardEntity);
        VirtualVisitEntity virtualVisit = virtualVisitEntityRepository.getById(virtualTicketEntity.getVirtual_visit_id());
        UserEntity userEntity = userEntityRepository.findById(virtualTicketEntity.getUser_id()).get();
        MuseumEntity museumEntity = museumEntityRepository.findById(virtualVisit.getMuseum_id()).get();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("tickets/" + virtualTicketEntity.getId() + ".pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk1 = new Chunk("Ticket for a virtual tour at "  + museumEntity.getName() + ".", font);
            Chunk chunk2 = new Chunk("   Ticket number: " + virtualTicketEntity.getId(), font);

            Chunk chunk3 = new Chunk("   Price: " + virtualVisit.getPrice() + "$", font);

            Chunk chunk4 = new Chunk("   Start time: " + virtualVisit.getStart_time(), font);
            Chunk chunk5 = new Chunk("   End time: " + virtualVisit.getEnd_time(), font);

            document.add(chunk1);
            document.add(new Paragraph("\n"));
            document.add(chunk2);
            document.add(new Paragraph("\n"));
            document.add(chunk3);
            document.add(new Paragraph("\n"));
            document.add(chunk4);
            document.add(new Paragraph("\n"));
            document.add(chunk5);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //emailService.sendVirtualTicket(virtualVisit, virtualTicketEntity, museumEntity.getName(), userEntity.getEmail());
        emailService.sendEmailWithAttachment(virtualTicketEntity);
        return ResponseEntity.ok(virtualTicketEntity);
    }
}
