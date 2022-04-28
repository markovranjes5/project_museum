package com.example.project_museum;

import com.example.project_museum.models.entities.VirtualTicketEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import com.example.project_museum.repositories.MuseumEntityRepository;
import com.example.project_museum.repositories.UserEntityRepository;
import com.example.project_museum.repositories.VirtualTicketEntityRepository;
import com.example.project_museum.repositories.VirtualVisitEntityRepository;
import com.example.project_museum.services.EmailService;
import com.example.project_museum.services.impl.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class ProjectMuseumApplication {

    private final VirtualTicketEntityRepository virtualTicketEntityRepository;
    private final VirtualVisitEntityRepository virtualVisitEntityRepository;
    private final MuseumEntityRepository museumEntityRepository;
    private final UserEntityRepository userEntityRepository;

    public ProjectMuseumApplication(VirtualTicketEntityRepository virtualTicketEntityRepository, VirtualVisitEntityRepository virtualVisitEntityRepository, MuseumEntityRepository museumEntityRepository, UserEntityRepository userEntityRepository) {
        this.virtualTicketEntityRepository = virtualTicketEntityRepository;
        this.virtualVisitEntityRepository = virtualVisitEntityRepository;
        this.museumEntityRepository = museumEntityRepository;
        this.userEntityRepository = userEntityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectMuseumApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper()
    {
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }

    @Bean
    public  EmailService emailService(){
        EmailServiceImpl emailServie= new EmailServiceImpl();
        return emailServie;
    }

    @Autowired
    EmailService emailService;

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }

    @PostConstruct

    public void init()
    {
        TimeZone.setDefault(TimeZone.getTimeZone("Central European Time"));
    }

    @Configuration
    @EnableScheduling
    public class SpringConfig {

    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        for(VirtualTicketEntity virtualTicket : virtualTicketEntityRepository.findAll()){
            VirtualVisitEntity virtualVisitEntity =virtualVisitEntityRepository.findById(virtualTicket.getVirtual_visit_id()).get();


            if(new Date(virtualVisitEntity.getStart_time().getTime() - 3600*1000).getTime()/1000 == new Date(new Date().getTime() + 2*3600*1000).getTime()/1000){
                System.out.println("Pocinje.");
                emailService.sendVisitReminder(virtualVisitEntity, virtualTicket, museumEntityRepository.findById(virtualVisitEntity.getMuseum_id()).get().getName(), userEntityRepository.findById(virtualTicket.getUser_id()).get().getEmail() );
            }

            if(new Date(virtualVisitEntity.getEnd_time().getTime() - 300*1000).getTime()/1000 == new Date(new Date().getTime() + 2 * 3600 * 1000).getTime()/1000){
                System.out.println("Zavrsava.");
                emailService.sendVisitEndingReminder(virtualVisitEntity, virtualTicket, museumEntityRepository.findById(virtualVisitEntity.getMuseum_id()).get().getName(), userEntityRepository.findById(virtualTicket.getUser_id()).get().getEmail() );
            }

        }
    }

}
