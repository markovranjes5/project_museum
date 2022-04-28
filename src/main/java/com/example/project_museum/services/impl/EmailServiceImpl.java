package com.example.project_museum.services.impl;

import com.example.project_museum.models.entities.VirtualTicketEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import com.example.project_museum.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendVisitReminder(VirtualVisitEntity virtualVisit, VirtualTicketEntity virtualTicket, String museum,  String email) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(email);
        simpleMessage.setSubject("Virtual visit reminder");
        simpleMessage.setText("Just a friendly reminder, that your virtual visit at " + museum + " starts in one hour.");

        javaMailSender.send(simpleMessage);
    }

    @Override
    public void sendVisitEndingReminder(VirtualVisitEntity virtualVisit, VirtualTicketEntity virtualTicket, String museum,  String email) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(email);
        simpleMessage.setSubject("Virtual visit reminder");
        simpleMessage.setText("Just a friendly reminder, that your virtual visit at " + museum + " ends in five mintues.");

        javaMailSender.send(simpleMessage);
    }

    @Override
    public void sendEmailWithAttachment(VirtualTicketEntity virtualTicket) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {

            // Set multipart mime message true
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                    true);

            mimeMessageHelper.setTo("marko.vranjes@student.etf.unibl.org");
            mimeMessageHelper
                    .setSubject("Virtual ticket.");
            mimeMessageHelper.setText(
                    "Thank you for purchasing a virtual ticket on our website.");

            // Attach the attachment
            mimeMessageHelper.addAttachment("Virtual ticket", new File("tickets/" + virtualTicket.getId() + ".pdf"));

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            System.out.println("Exeception=>sendEmailWithAttachment " +  e);
        }
    }
}
