package servlet;

import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.LoginBean;

import java.io.IOException;

@WebServlet("/login")
public class LogoutServlet extends HttpServlet {

    @EJB
    private LoginBean loginBean;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final FacesContext fc = FacesContext.getCurrentInstance();
        final HttpServletRequest request =
                (HttpServletRequest) fc.getExternalContext().getRequest();
        try {

            loginBean.logout(request.getParameter("username"));
            request.logout();
            request.getSession().invalidate();
            resp.getWriter().println(String.format("<html><body>User: %s<br>successfully logged out:%s</body></html>", req.getParameter("user"), req.getParameter("password")));

        } catch (Exception e) {

            resp.getWriter().println(String.format("<html><body><p style=\"color:red\">logging out failed</p></body></html>", e.getMessage()));
        }
        request.getSession(false).invalidate();

    }
}
