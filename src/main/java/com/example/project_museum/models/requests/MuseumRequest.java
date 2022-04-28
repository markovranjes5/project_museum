package com.example.project_museum.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuseumRequest {

    private String name;
    private String address;
    private String city;
    private String country;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer museum_type_id;
    private String img;
    private String description;
}
