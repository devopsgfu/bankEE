package login;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;

@Local
public interface LoginInterface {
     String login(String username, String password);
     String logout(String username);
}
