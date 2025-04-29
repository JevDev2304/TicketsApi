package com.ticketsapi.ticketsapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CustomerD {
    private String idD;
    private String nameD;
    private String lastNameD;
    private String cellPhoneD;
    private String addressD;
    private String mailD;
    private String passwordD;
    private String profilePictureD;

    public String getIdD() {
        return idD;
    }

    public void setIdD(String idD) {
        this.idD = idD;
    }

    public String getLastNameD() {
        return lastNameD;
    }

    public void setLastNameD(String lastNameD) {
        this.lastNameD = lastNameD;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public String getCellPhoneD() {
        return cellPhoneD;
    }

    public void setCellPhoneD(String cellPhoneD) {
        this.cellPhoneD = cellPhoneD;
    }

    public String getAddressD() {
        return addressD;
    }

    public void setAddressD(String addressD) {
        this.addressD = addressD;
    }

    public String getMailD() {
        return mailD;
    }

    public void setMailD(String mailD) {
        this.mailD = mailD;
    }

    public String getPasswordD() {
        return passwordD;
    }

    public void setPasswordD(String passwordD) {
        this.passwordD = passwordD;
    }

    public String getProfilePictureD() {
        return profilePictureD;
    }

    public void setProfilePictureD(String profilePictureD) {
        this.profilePictureD = profilePictureD;
    }


}
