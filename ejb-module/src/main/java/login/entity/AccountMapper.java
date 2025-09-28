package login.entity;

import address.EntityMapper;
import com.example.sharedejb.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface AccountMapper extends EntityMapper<Account, AccountDTO> {

}
