package com.example.project_museum.models.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "virtual_presentation")
public class VirtualPresentationEntity {
    @EmbeddedId
    private VirtualPresentationId id;

    @Column(name = "img1", nullable = false)
    private String img1;

    @Column(name = "img2", nullable = false)
    private String img2;

    @Column(name = "img3", nullable = false)
    private String img3;

    @Column(name = "img4", nullable = false)
    private String img4;

    @Column(name = "img5", nullable = false)
    private String img5;

    @Column(name = "img6", nullable = false)
    private String img6;

    @Column(name = "img7", nullable = false)
    private String img7;

    @Column(name = "img8", nullable = false)
    private String img8;

    @Column(name = "img9", nullable = false)
    private String img9;

    @Column(name = "img10", nullable = false)
    private String img10;

    @Column(name = "video", nullable = false)
    private String video;



    public VirtualPresentationId getId() {
        return id;
    }

    public void setId(VirtualPresentationId id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public String getImg7() {
        return img7;
    }

    public void setImg7(String img7) {
        this.img7 = img7;
    }

    public String getImg8() {
        return img8;
    }

    public void setImg8(String img8) {
        this.img8 = img8;
    }

    public String getImg9() {
        return img9;
    }

    public void setImg9(String img9) {
        this.img9 = img9;
    }

    public String getImg10() {
        return img10;
    }

    public void setImg10(String img10) {
        this.img10 = img10;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualPresentationEntity that = (VirtualPresentationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(img1, that.img1) && Objects.equals(img2, that.img2) && Objects.equals(img3, that.img3) && Objects.equals(img4, that.img4) && Objects.equals(img5, that.img5) && Objects.equals(img6, that.img6) && Objects.equals(img7, that.img7) && Objects.equals(img8, that.img8) && Objects.equals(img9, that.img9) && Objects.equals(img10, that.img10) && Objects.equals(video, that.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, video);
    }
}