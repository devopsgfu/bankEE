package login;

import com.example.sharedejb.LoginInterface;
import com.example.sharedejb.dto.AccountDTO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import login.entity.Account;
import login.entity.AccountMapper;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class LoginBean implements LoginInterface {

    @PersistenceContext(unitName = "bankPU")
    private EntityManager em;

    @Inject
    private AccountMapper accountMapper;

    @Override
    public void login(AccountDTO account) throws Exception {

        // beispielhafte Implementierung mit JPQL obwohl
        // einfaches SELECT Kritirium in diesem Fall einfacher wäre
        //
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Account> query = cb.createQuery(Account.class);
        final Root<Account> selectAccount = query.from(Account.class);

        final Predicate username = cb.equal(selectAccount
                .get("username"),account.getUsername());
        final Predicate password = cb.equal(selectAccount.get("password"),account.getPassword());
        final Predicate and = cb.and(username, password);

        query.select(selectAccount).where(and);

        try {
             em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
           throw new Exception(e.getMessage());
        }
    }

    @Override
    public void logout(String username) throws Exception {

        final TypedQuery<Account> accountQuery = em.createNamedQuery("Account.findByUsername", Account.class);

        try {
            Optional.ofNullable(accountQuery.getSingleResult()).orElseThrow();

        }catch (NoResultException e){
            // hier loggen: benuter nicht gefunden
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE,e.getMessage(),e);
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void register(AccountDTO accountDTO) throws Exception {

        final Account account = accountMapper.dtoToEntity(accountDTO);
        em.persist(account);
    }

    @Transactional
    @Override
    public void unregister(AccountDTO accountDTO) throws Exception {

        final TypedQuery<Account> accountQuery = em.
                createNamedQuery("Account.findByUsername", Account.class);

        try {
            final Account account = Optional.ofNullable(accountQuery.getSingleResult()).orElseThrow();
            em.remove(account);

        }catch (NoResultException e){
            // hier loggen: benuter nicht gefunden
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE,e.getMessage(),e);
            throw new Exception(e.getMessage());
        }

    }

}
