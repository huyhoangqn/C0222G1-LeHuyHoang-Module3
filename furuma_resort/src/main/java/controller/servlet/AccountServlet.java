package controller.servlet;

import model.repository.account.AccountRepository;
import model.service.account.AccountService;
import model.service.account.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = {"", "/auth"})
public class AccountServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login": {
                login(request, response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }

        switch (action) {
            case "logout": {
                logout(request, response);
                break;
            }

        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            boolean isValid = accountService.account(userName, password);
            if (isValid) {
                HttpSession session = request.getSession();
                session.setAttribute("tenDangNhap", userName);
                request.getRequestDispatcher("/view/furama.jsp").forward(request, response);

            } else {
                getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {

            HttpSession session = request.getSession();
            session.removeAttribute("tenDangNhap");
            getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
