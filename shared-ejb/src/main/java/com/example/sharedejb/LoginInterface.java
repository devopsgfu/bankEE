package com.example.sharedejb;

import jakarta.ejb.Remote;

@Remote
public interface LoginInterface {
     void login(String username, String password) throws Exception;
     String logout(String username);
}
