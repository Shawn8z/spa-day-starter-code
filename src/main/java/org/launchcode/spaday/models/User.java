package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 5, max = 15, message = "Username Should have the length between 5 and 15 characters")
    private String username;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    @Email
    private String email;


    public User() {}

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        this.checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword();
    }

    private void checkPassword() {
        if ( (password != null && verifyPassword != null) && !password.equals(verifyPassword) ) {
            this.verifyPassword = null;
        }
    }
}
