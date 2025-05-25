package com.backend.myTicket.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters")
    private String username;
    @NotBlank(message = "FullName is mandatory")
    @Size(min = 2, max = 100, message = "FullName must be between 2 and 100 characters")
    private String fullName;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 2, max = 100, message = "Password must be between 2 and 255 characters")
    private String password;
    @Size( max = 255, message = "Profile picture must be less than 255 characters")
    private String profilePicture;

    public UserRequest() {}
    public UserRequest(String username, String fullName, String password, String profilePicture) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
