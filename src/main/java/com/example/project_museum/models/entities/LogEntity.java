package com.example.project_museum.models.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "log")
@AllArgsConstructor
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "time", nullable = false, length = 4)
    private Timestamp time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return Objects.equals(id, logEntity.id) && Objects.equals(action, logEntity.action) && Objects.equals(time, logEntity.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, time);
    }

    public LogEntity(String action, Timestamp time){
        this.action = action;
        this.time = time;
    }

    public LogEntity(){

    }
}
