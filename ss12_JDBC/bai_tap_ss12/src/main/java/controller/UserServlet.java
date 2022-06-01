package controller;

import model.bean.User;
import model.service.IUserService;
import model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search": {
                showFormSearch(request, response);
                break;
            }
            case "sort": {
                showUserListBySort(request, response);
                break;
            }
            default:
                showUserList(request, response);
                break;
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAllUsers();
        try {
            request.setAttribute("users", userList);
            request.getRequestDispatcher("view/user.jsp").forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> userList = userService.searchUser(country);
        request.setAttribute("users", userList);
        try {
            request.getRequestDispatcher("view/user.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showUserListBySort(HttpServletRequest request, HttpServletResponse response) {
        String sortData = request.getParameter("sortData");
        List<User> userList = userService.searchAllBySort(sortData);
        request.setAttribute("users", userList);
        try {
            request.getRequestDispatcher("view/user.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
