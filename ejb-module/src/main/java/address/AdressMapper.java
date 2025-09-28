package address;

import address.entity.Address;
import com.example.sharedejb.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface AdressMapper extends EntityMapper<Address,AddressDTO> {

}
