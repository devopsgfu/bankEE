package address;

import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class Address implements AddressInterface{
    List<String> addresses = new ArrayList<>();

    @Override
    public String addAddress(String address) {
        if(address.isEmpty()){
            return "Address is empty";
        } else {
            addresses.add(address);
            return "Address is added to database";
        }
    }

    @Override
    public String removeAddress(String address) {
        if(address.isEmpty()){
            return "Address is empty";
        } else if (addresses.contains(address)) {
            addresses.remove(address);
            return "Address is remove from database";
        }
        return "";
    }
}
