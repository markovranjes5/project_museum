package com.example.project_museum.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualTicketRequest {
    private int card_number;
    private String pin;
    private String expiration_date;
    private String firstname;
    private String lastname;
    private String type;
    private double price;
    private int virtual_visit_id;
    private int user_id;
}
