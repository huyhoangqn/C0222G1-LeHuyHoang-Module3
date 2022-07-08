package controller;

import model.service.hoc_sinh.HocSinhImpl;
import model.service.hoc_sinh.IHocSinh;
import model.service.sach.ISach;
import model.service.sach.SachImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ThuVienServlet", urlPatterns = "/thuvien")
public class ThuVienServlet extends HttpServlet {
    ISach sach = new SachImpl();
    IHocSinh hocSinh = new HocSinhImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "listSach";
        }
        switch (action) {
            case "listSach":
                showList(request, response);
                break;
            case "muonSach":
                showFormMuon(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("listSach", sach.findAll());
            request.getRequestDispatcher("view/listSach.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException | SQLException e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }

    private void showFormMuon(HttpServletRequest request, HttpServletResponse response) {
        try {
            String maSach = request.getParameter("id");
            request.setAttribute("sach", sach.findById(maSach));
            request.setAttribute("hocsinhs", hocSinh.findAll());
            request.getRequestDispatcher("view/muonSach.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
