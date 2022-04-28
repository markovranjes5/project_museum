package com.example.project_museum.services;

import com.example.project_museum.models.entities.VirtualTicketEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface EmailService {

    void sendVisitReminder(VirtualVisitEntity virtualVisit, VirtualTicketEntity virtualTicket, String museum, String email);

    void sendVisitEndingReminder(VirtualVisitEntity virtualVisit, VirtualTicketEntity virtualTicket, String museum, String email);

    void sendEmailWithAttachment(VirtualTicketEntity virtualTicket);

}
