package address;

import jakarta.ejb.Stateless;

@Stateless
public class Address implements AddressInterface{

    @Override
    public String addAddress(String address) {
        if(address.isEmpty()){
            return "Address is empty";
        } else if (address.equals("Testaddress")) {
            return "Address is added to database";
        }
        return "";
    }

    @Override
    public String removeAddress(String address) {
        if(address.isEmpty()){
            return "Address is empty";
        } else if (address.equals("Testaddress")) {
            return "Address is remove from database";
        }
        return "";
    }
}
