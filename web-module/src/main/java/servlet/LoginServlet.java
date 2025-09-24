package servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.LoginInterface;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private LoginInterface loginInterface;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            loginInterface.login(req.getParameter("user"), req.getParameter("password"));
            resp.getWriter().println(String.format("<html><body>User: %s<br>Passwort:%s</body></html>", req.getParameter("user"), req.getParameter("password")));
        } catch (Exception e) {
            resp.getWriter().println(String.format("<html><body><p style=\"color:red\">%s</p></body></html>", e.getMessage()));
        }
    }
}
