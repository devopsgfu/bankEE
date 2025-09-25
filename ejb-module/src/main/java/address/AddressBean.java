package address;

import address.entity.Address;
import com.example.sharedejb.AddressInterface;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AddressBean implements AddressInterface {
    private List<String> addresses = new ArrayList<>(List.of("Testadresse"));

    @PersistenceContext(unitName = "bankPU")
    private EntityManager em;


    @Override
    public void addAddress(String address) {
        if(!address.isEmpty()){
            em.persist(address);
        }
    }

    @Override
    public void removeAddress(String address) {
        em.createQuery("delete from Address a where a.id = :id").setParameter("id", address).executeUpdate();
//        addresses.remove(address);
    }

    @Override
    public List<String> getAddresses() {
        return em.createQuery("select a from Address a where a.id = :id", Address.class).getResultList().stream().
                map(Address::getStrasse).collect(Collectors.toList());
    }
}
