package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerController", urlPatterns = "")
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer[] customers = new Customer[2];
        customers[0] = new Customer("Mai Văn Hoàng", "1983-08-20", "Hà Nội", "img\\anh.jpg");
        customers[1] = new Customer("Mai Văn Hoàng", "1983-08-20", "Hà Nội", "img\\anh.jpg");
        request.setAttribute("listCustomer", customers);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
