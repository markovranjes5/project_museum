package com.example.project_museum.models.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @EmbeddedId
    private TransactionEntityId id;

    @Column(name = "old_balance", nullable = false, precision = 10, scale = 5)
    private BigDecimal oldBalance;

    @Column(name = "new_balance", nullable = false, precision = 10, scale = 5)
    private BigDecimal newBalance;

    @Column(name = "time", nullable = false)
    private Instant time;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public BigDecimal getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(BigDecimal oldBalance) {
        this.oldBalance = oldBalance;
    }

    public TransactionEntityId getId() {
        return id;
    }

    public void setId(TransactionEntityId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(oldBalance, that.oldBalance) && Objects.equals(newBalance, that.newBalance) && Objects.equals(time, that.time);
    }

    public TransactionEntity(){

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oldBalance, newBalance, time);
    }

    public TransactionEntity(TransactionEntityId id, BigDecimal oldBalance, BigDecimal newBalance, Instant time) {
        this.id = id;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
        this.time = time;
    }
}