package address;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Address implements AddressInterface {
    private List<String> addresses = new ArrayList<>(List.of("Testadresse"));


    @Override
    public void addAddress(String address) {
        if(!address.isEmpty()){
            addresses.add(address);
        }
    }

    @Override
    public void removeAddress(String address) {
        addresses.remove(address);

    }

    @Override
    public List<String> getAddresses() {
        return addresses;
    }
}
