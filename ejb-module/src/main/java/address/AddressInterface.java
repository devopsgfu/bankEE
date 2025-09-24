package address;

import jakarta.ejb.Remote;

@Remote
public interface AddressInterface {
     String addAddress(String address);
     String removeAddress(String address);
}
