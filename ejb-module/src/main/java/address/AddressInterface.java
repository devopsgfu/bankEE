package address;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;

import java.util.List;

@Local
public interface AddressInterface {
     void addAddress(String address);
     void removeAddress(String address);
     List<String> getAddresses();
}
