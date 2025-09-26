package address;


import address.entity.Address;
import com.example.sharedejb.dto.AddressDTO;

@Mapper
public interface MapperInterface {


        AddressDTO sourceToDestination(Address source);
        Address destinationToSource(AddressDTO destination);

}
