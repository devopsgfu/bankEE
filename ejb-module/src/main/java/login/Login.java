package login;

public class Login implements LoginInterface {

    @Override
    public String login(String username, String password) {
        boolean checkUserExists = true;
        String testpassword="test";

        if(checkUserExists && password.equals(testpassword)){
            return "User successfully logged in";
        }
        return "User does not exist or password incorrect";
    }

    @Override
    public String logout(String username) {
        return "User successfully logged out";
    }
}
