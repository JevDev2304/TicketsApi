package com.backend.myTicket.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "name", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String host;
    @Column(nullable = true)
    private String host_image;


    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Event() {}

    public Event(Integer id, String name, String location, Category category, String host, String host_image, String description, Date date, String image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.host = host;
        this.host_image = host_image;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String getHost_image() {
        return host_image;
    }

    public void setHost_image(String host_image) {
        this.host_image = host_image;
    }

    private String image;

}