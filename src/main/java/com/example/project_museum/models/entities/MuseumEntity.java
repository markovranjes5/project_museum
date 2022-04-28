package com.example.project_museum.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "museum")
public class MuseumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "longitude", nullable = false, precision = 10, scale = 5)
    private BigDecimal longitude;

    @Column(name = "latitude", nullable = false, precision = 10, scale = 5)
    private BigDecimal latitude;

    @Column(name = "museum_type_id", nullable = false)
    private Integer museum_type_id;

    @Column(name = "img", nullable = false, length = 50)
    private String img;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMuseum_type_id() {
        return museum_type_id;
    }

    public void setMuseum_type_id(Integer museumType_id) {
        this.museum_type_id = museumType_id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        MuseumEntity that = (MuseumEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude) && Objects.equals(museum_type_id, that.museum_type_id) && Objects.equals(img, that.img) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, city, country, longitude, latitude, museum_type_id, img, description);
    }
}