package com.example.sharedejb;

import com.example.sharedejb.dto.AddressDTO;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface AddressInterface {
     void addAddress(AddressDTO address);
     void removeAddress(AddressDTO address);
     List<AddressDTO> getAddresses();
}
