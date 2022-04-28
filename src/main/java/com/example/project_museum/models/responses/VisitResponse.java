package com.example.project_museum.models.responses;

import com.example.project_museum.models.entities.VirtualVisitEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitResponse {
    private Integer ticket_id;
    private Integer museum_id;
    private String museum_name;
    private VirtualVisitEntity visit;
}
