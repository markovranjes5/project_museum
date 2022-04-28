package com.example.project_museum.models.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VirtualPresentationRequest {

    private String video;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;
    private String img7;
    private String img8;
    private String img9;
    private String img10;
    private Integer museum_id;
}
