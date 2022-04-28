package com.example.project_museum.models.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionEntityId implements Serializable {
    private static final long serialVersionUID = -7297316593557238175L;
    @Column(name = "virtual_ticket_id", nullable = false)
    private Integer virtualTicketId;
    @Column(name = "credit_card_card_number", nullable = false)
    private Integer creditCardCardNumber;

    public Integer getCreditCardCardNumber() {
        return creditCardCardNumber;
    }

    public void setCreditCardCardNumber(Integer creditCardCardNumber) {
        this.creditCardCardNumber = creditCardCardNumber;
    }

    public Integer getVirtualTicketId() {
        return virtualTicketId;
    }

    public void setVirtualTicketId(Integer virtualTicketId) {
        this.virtualTicketId = virtualTicketId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardCardNumber, virtualTicketId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TransactionEntityId entity = (TransactionEntityId) o;
        return Objects.equals(this.creditCardCardNumber, entity.creditCardCardNumber) &&
                Objects.equals(this.virtualTicketId, entity.virtualTicketId);
    }

    public TransactionEntityId(){

    }

    public TransactionEntityId(Integer virtualTicketId, Integer creditCardCardNumber) {
        this.virtualTicketId = virtualTicketId;
        this.creditCardCardNumber = creditCardCardNumber;
    }
}