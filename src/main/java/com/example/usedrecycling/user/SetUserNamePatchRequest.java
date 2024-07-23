package com.example.usedrecycling.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetUserNamePatchRequest {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
