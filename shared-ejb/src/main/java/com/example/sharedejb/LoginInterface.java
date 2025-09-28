package com.example.sharedejb;

import com.example.sharedejb.dto.AccountDTO;
import jakarta.ejb.Remote;

@Remote
public interface LoginInterface {
     void login(AccountDTO accountDTO) throws Exception;
     void logout(String username) throws Exception;
     void register(AccountDTO accountDTO) throws Exception;
     void unregister(AccountDTO accountDTO) throws Exception;
}
