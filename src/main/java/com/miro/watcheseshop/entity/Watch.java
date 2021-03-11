package com.miro.watcheseshop.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="watch")
public class Watch {
    @SequenceGenerator(name = "WATCHES_SEQ", sequenceName = "WATCHES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WATCHES_SEQ")

    @Id()
    @Column(name="ID")
    private Long id;
    @Column(name="TITLE",nullable = false, length=80)
    private String title;
    @Column(name="PRICE")
    private int price;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="FOUNTAIN")
    private String fountain;

    public Watch() {
    }

    public Watch(Long id) {
        this.id = id;
    }

    public Watch(String title, int price, String description, String fountain) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.fountain = fountain;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFountain() {
        return fountain;
    }

    public void setFountain(String fountain) {
        this.fountain = fountain;
    }
}
