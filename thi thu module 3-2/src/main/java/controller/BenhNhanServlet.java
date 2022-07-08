package controller;

import model.bean.BenhAn;
import model.bean.BenhNhan;
import model.service.benh_an.BenhAnImpl;
import model.service.benh_an.IBenhAn;
import model.service.benh_nhan.BenhNhanImpl;
import model.service.benh_nhan.IBenhNhan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", urlPatterns = {"/benhnhan"})
public class BenhNhanServlet extends HttpServlet {
    IBenhNhan benhNhan = new BenhNhanImpl();
    IBenhAn benhAn = new BenhAnImpl();

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
            case "edit":
                try {
                    update(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNham = request.getParameter("tenBenhNham");
        Date ngayNhap = Date.valueOf(request.getParameter("ngayNhap"));
        Date ngayXuat = Date.valueOf(request.getParameter("ngayXuat"));
        String maBanhAn = request.getParameter("maBanhAn");
        String lyDoNhapVien = request.getParameter("lyDoNhapVien");
        BenhAn benhAn1 = new BenhAn(maBanhAn, lyDoNhapVien);
        BenhNhan benhNhan1 = new BenhNhan(maBenhNhan, tenBenhNham, ngayNhap, ngayXuat);
        benhAn.update(benhAn1);

//        benhNhan.update(benhNhan1);
        List<String> errors = benhNhan.add(benhNhan1);
        if (errors.isEmpty()) {
            request.setAttribute("message", "Sua thanh cong");
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("benhnhan", benhNhan1);
            request.setAttribute("benhan", benhAn1);
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
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
            case "delete": {
                delete(request, response);
                break;
            }
            case "edit":
                showFormEdit(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            String maBenhNhan = request.getParameter("id");
            benhNhan.delete(maBenhNhan);
            response.sendRedirect("/benhnhan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("benhan", benhAn.fillAll());
            request.setAttribute("benhnhan", benhNhan.fillAll());
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException | SQLException e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            request.setAttribute("benhan", benhAn.fillAll());
            request.setAttribute("benhnhan", benhNhan.findById(id));
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
