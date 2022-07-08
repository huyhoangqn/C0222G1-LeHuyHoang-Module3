package controller;

import model.bean.Product;
import model.service.category.CategoryService;
import model.service.category.CategoryServiceImpl;
import model.service.product.ProductService;
import model.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list": {
                showList(request, response);
                break;
            }
            case "create": {
                add(request, response);
                break;
            }
            case "edit": {
                update(request, response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list": {
                showList(request, response);
                break;
            }
            case "create": {
                showCreate(request, response);
                break;
            }
            case "edit": {
                showFormEdit(request, response);
                break;
            }
            case "delete": {
                delete(request, response);
                break;
            }
            case "search": {
                search(request, response);
                break;
            }
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("category", productService.findAllCategory());
            request.setAttribute("products", productService.findAll()); // Lấy List đối tượng product để đổ vào list.jsp
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException | SQLException e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String color = request.getParameter("color");
            String idCategory = request.getParameter("idCategory");
            request.setAttribute("category", productService.findAllCategory());
            request.setAttribute("products", productService.search(name, color, idCategory));
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            productService.delete(id);
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("product", productService.findById(id));
            request.setAttribute("categories", categoryService.findAll());
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            Product product = new Product(id, name, price, quantity, color, description);
            List<String> result = productService.update(product, categoryId);
            request.setAttribute("action", "edit");
            request.setAttribute("result", result);
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("categories", categoryService.findAll());
            request.setAttribute("product", product);

        } catch (Exception e) {
            List<String> result = new ArrayList<>();
            result.add("update fail");
            request.setAttribute("result", result);

            request.setAttribute("categories", categoryService.findAll());

        }
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);


    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("categories", categoryService.findAll());
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));

            Product product = new Product(name, price, quantity, color, description);
            List<String> result = productService.create(product, categoryId);

            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
            List<String> result = new ArrayList<>();
            result.add("create fail");
            request.setAttribute("result", result);
            request.setAttribute("categories", categoryService.findAll());
        }

        request.getRequestDispatcher("view/create.jsp").forward(request, response);
    }

}
