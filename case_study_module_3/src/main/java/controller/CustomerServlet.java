package controller;

import model.bean.Customer;
import model.service.customer.CustomerService;
import model.service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addNewCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                response.sendRedirect("view/customer/addCustomer.jsp");
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                getCustomer(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }


    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        try {
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int maLoaiKhach = Integer.parseInt(request.getParameter("maLoaiKhach"));
        String hoTen = request.getParameter("tenKhachHang");
        String ngaySinh = request.getParameter("ngaySinh");
        Integer gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String soDienThoai = request.getParameter("soDT");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        Customer customer = new Customer(maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);
        List<String> errors = customerService.add(customer);
        if (errors.isEmpty()) {
            errors.add("create success");
        }
        try {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/view/customer/addCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("maKhachHang"));
        customerService.deleteCustomer(id);
        request.setAttribute("message", "Xóa thành công");
        showCustomerList(request, response);
    }

    private void getCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = new Customer();
        customer = customerService.getCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        int maLoaiKhach = Integer.parseInt(request.getParameter("maLoaiKhach"));
        String hoTen = request.getParameter("tenKhachHang");
        String ngaySinh = request.getParameter("ngaySinh");
        Integer gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String soDienThoai = request.getParameter("soDT");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        customerService.updateCustomer(maKhachHang, maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);
        request.setAttribute("message", "Cập nhật thành công!");
        showCustomerList(request, response);
    }


}
