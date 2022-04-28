package com.example.project_museum.models.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "virtual_ticket")
public class VirtualTicketEntity {
    public VirtualTicketEntity(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "virtual_visit_id", nullable = false)
    private Integer virtual_visit_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getVirtual_visit_id() {
        return virtual_visit_id;
    }

    public void setVirtual_visit_id(Integer virtual_visit_id) {
        this.virtual_visit_id = virtual_visit_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualTicketEntity that = (VirtualTicketEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(user_id, that.user_id) && Objects.equals(virtual_visit_id, that.virtual_visit_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, virtual_visit_id);
    }

    public VirtualTicketEntity(Integer user_id, Integer virtual_visit_id){
        this.user_id = user_id;
        this.virtual_visit_id = virtual_visit_id;
    }
}