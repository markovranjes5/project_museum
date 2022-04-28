package com.example.project_museum.models.entities;

import com.example.project_museum.models.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "credit_card")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_number", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "pin", nullable = false, length = 4)
    private String pin;

    @Column(name = "expiration_date", nullable = false, length = 5)
    private String expirationDate;

    @Column(name = "balance", nullable = false, precision = 10, scale = 5)
    private BigDecimal balance;

    @Column(name = "blocked", nullable = false)
    private Character blocked;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Character getBlocked() {
        return blocked;
    }

    public void setBlocked(Character blocked) {
        this.blocked = blocked;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        CreditCardEntity that = (CreditCardEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(pin, that.pin) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(balance, that.balance) && Objects.equals(blocked, that.blocked) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, pin, expirationDate, balance, blocked, firstname, lastname);
    }
}