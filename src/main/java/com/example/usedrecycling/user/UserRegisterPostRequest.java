package com.example.usedrecycling.user;

public class UserRegisterPostRequest {
    public String username;
    public String email;
    public String passwd;

    public UserRegisterPostRequest(String username, String email, String passwd) {
        this.username = username;
        this.email = email;
        this.passwd = passwd;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
