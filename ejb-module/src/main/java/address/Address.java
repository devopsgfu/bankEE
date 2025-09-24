package address;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Address implements AddressInterface{
    List<String> addresses = new ArrayList<>(List.of("Testadresse"));

    @Override
    public String toString() {
        StringBuilder string_list = new StringBuilder();
        for (String address : addresses) {
            string_list.append(address + " ");
        }
        return super.toString();
    }

    @Override
    public String addAddress(String address) {
        if(address.isEmpty()){
            return toString();
        } else {
            addresses.add(address);
            return toString();
        }
    }

    @Override
    public String removeAddress(String address) {
        if(address.isEmpty()){
            return toString();
        } else if (addresses.contains(address)) {
            addresses.remove(address);
            return toString();
        }
        return "";
    }
}
