package com.example.sharedejb;

import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface AddressInterface {
     void addAddress(String address);
     void removeAddress(String address);
     List<Object> getAddresses();
}
