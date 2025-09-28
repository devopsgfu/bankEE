package com.example.sharedejb.dto;

public class AccountDTO {

    private String username;
    private String password;

    public AccountDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
