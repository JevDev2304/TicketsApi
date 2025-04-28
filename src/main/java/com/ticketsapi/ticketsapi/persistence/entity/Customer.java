package com.ticketsapi.ticketsapi.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;
    @Column(name= "nombre")
    private String name;
    @Column(name= "apellidos")
    private String lastName;
    @Column(name= "celular")
    private  String cellPhone;
    @Column(name= "direccion")
    private String address;
    @Column(name= "correo_electronico")
    private String mail;
    @Column(name= "contraseña")
    private String password;
    @Column(name= "imagen")
    private String profilePicture;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
