package com.example.project_museum.models.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VirtualPresentationId implements Serializable {
    private static final long serialVersionUID = -7698961557044514317L;
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "museum_id", nullable = false)
    private Integer museumId;

    public Integer getMuseumId() {
        return museumId;
    }

    public void setMuseumId(Integer museumId) {
        this.museumId = museumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualPresentationId that = (VirtualPresentationId) o;
        return Objects.equals(id, that.id) && Objects.equals(museumId, that.museumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, museumId);
    }
}