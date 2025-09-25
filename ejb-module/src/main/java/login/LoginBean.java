package login;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class LoginBean implements LoginInterface {

    @PersistenceContext(unitName = "bankPU")
    private EntityManager em;

    @Override
    public void login(String username, String password) throws Exception {
        boolean checkUserExists = true;
        String testpassword="test";

        if(!(checkUserExists && testpassword.equals(password))){
            throw new Exception("User does not exist or password incorrect");
        }
    }

    @Override
    public String logout(String username) {
        return "User successfully logged out";
    }
}
