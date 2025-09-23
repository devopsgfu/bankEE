package address;

import jakarta.ejb.Remote;

@Remote
public interface AddressInterface {
    public String addAddress(String address);
    public String removeAddress(String address);
}
