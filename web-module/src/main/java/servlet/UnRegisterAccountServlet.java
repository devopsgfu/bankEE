package servlet;

import com.example.sharedejb.dto.AccountDTO;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.LoginBean;

import java.io.IOException;

@WebServlet("/unregister")
public class UnRegisterAccountServlet extends HttpServlet {

    @EJB
    private LoginBean loginBean;

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {

            final AccountDTO accountDTO = new AccountDTO(req.getParameter("user"),
                    req.getParameter("password"));
            loginBean.unregister(accountDTO);
            resp.getWriter().println(String.format("<html><body>User: %s<br>Passwort:%s</body></html>", req.getParameter("user"), req.getParameter("password")));
        } catch (Exception e) {
            resp.getWriter().println(String.format("<html><body><p style=\"color:red\">%s</p></body></html>", e.getMessage()));
        }
    }
}
