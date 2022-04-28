package com.example.project_museum.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "virtual_visit")
public class VirtualVisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "start_time", nullable = false)
    private Timestamp start_time;

    @Column(name = "end_time", nullable = false)
    private Timestamp end_time;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "museum_id", nullable = false)
    private Integer museum_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMuseum_id() {
        return museum_id;
    }

    public void setMuseum_id(Integer museum_id) {
        this.museum_id = museum_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualVisitEntity that = (VirtualVisitEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(start_time, that.start_time) && Objects.equals(end_time, that.end_time) && Objects.equals(price, that.price) && Objects.equals(museum_id, that.museum_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_time, end_time, price, museum_id);
    }
}