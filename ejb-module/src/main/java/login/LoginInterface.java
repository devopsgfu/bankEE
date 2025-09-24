package login;

import jakarta.ejb.Remote;

@Remote
public interface LoginInterface {
     String login(String username, String password);
     String logout(String username);
}
