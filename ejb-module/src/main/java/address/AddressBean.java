package address;

import address.entity.Address;
import com.example.sharedejb.AddressInterface;
import com.example.sharedejb.dto.AddressDTO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AddressBean implements AddressInterface {

    @PersistenceContext(unitName = "bankPU")
    private EntityManager em;


    @Override
    public void addAddress(AddressDTO address) {
        if(!address.getStrasse().isEmpty()){
            em.persist(address);
        }
    }

    @Override
    public void removeAddress(AddressDTO address) {
        em.createQuery("delete from Address a where a.id = :id").setParameter("id", address).executeUpdate();
    }

    @Override
    public List<AddressDTO> getAddresses() {
        return em.createQuery("select a from Address a where a.id = :id", Address.class).getResultList().stream().collect(Collectors.toList());
    }
}
