package controller;

import model.Product;
import repository.impl.ProductRepo;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "update":
                updateInfo(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "detail":
                getInfo(request, response);
                break;
            case "update":
                goUpdate(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                goProducttList(request, response); //Trường hợp người dùng không có yêu cầu gì mặc định câu lệnh trong default sẽ chạy
                break;
        }
    }


    private void goProducttList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productService.getListStudent());
        request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = productService.position();
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        Product product = new Product(id, name, price, description, manufacturer);
        productService.save(product);
        request.setAttribute("message", "register complete");
        goProducttList(request, response);
    }

    private void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/product/detail.jsp").forward(request, response);
    }

    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/product/update.jsp").forward(request, response);
    }

    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id")); //Nhận id từ view truyền sang
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        Product product = new Product(id, name, price, description, manufacturer);
        productService.save(product);
        request.setAttribute("message", "update complete");
        goProducttList(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        productService.deleteById(id);
        request.setAttribute("message", "delete complete");
        goProducttList(request, response);
    }

}
