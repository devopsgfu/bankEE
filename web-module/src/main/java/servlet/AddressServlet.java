package servlet;

import address.AddressInterface;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {

    @EJB
    private AddressInterface addressInterface;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String address = request.getParameter("address");

        String delete = request.getParameter("deleteAddress");

        if("on".equalsIgnoreCase(delete)){
            addressInterface.removeAddress(address);
        } else {
            addressInterface.addAddress(address);
        }

        out.println("<html>");
        out.println("<head><title>Hello Jakarta EE</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from Jakarta EE Servlet!</h1>");
        out.println("<p>Current Address: " + addressInterface.getAddresses() + "</p>");
        out.println("</body>");
        out.println("</html>");


    }
}
