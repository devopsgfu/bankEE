package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.getWriter().println(String.format("<html><body><h3>Anschrift:<h3> %s %s <br> %s %s</body></html>", req.getParameter("street"),
                req.getParameter("hNumber"), req.getParameter("plz"), req.getParameter("city")));
    }
}
