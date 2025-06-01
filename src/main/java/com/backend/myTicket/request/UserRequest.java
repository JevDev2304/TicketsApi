package com.backend.myTicket.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "Email is mandatory")
    @Size(min = 5, max = 100, message = "Email must be between 5 and 100 characters")
    private String email;
    @NotBlank(message = "FullName is mandatory")
    @Size(min = 2, max = 100, message = "FullName must be between 2 and 100 characters")
    private String fullName;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 2, max = 100, message = "Password must be between 2 and 255 characters")
    private String password;
    @Size( max = 255, message = "Profile picture must be less than 255 characters")
    private String profilePicture;

    public UserRequest(String email, String fullName, String password, String profilePicture) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
