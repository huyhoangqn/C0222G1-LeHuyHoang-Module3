package controller;

import dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = "/studentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                registerNewStudent(request, response);
                break;
            case "update":
                updateInfo(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Người dùng sẽ gửi 1 request thì doGet sẽ nhận trước
        //Yêu cầu người dùng truyền vào 1 tham số, ở đây là action. Mục đích: để biết người dùng họ muốn yêu cầu gì
        //đối với trang web của mình ví dụ như thêm sửa xóa sinh viên
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
                deleteStudent(request, response);
                break;
            default:
                goStudentList(request, response); //Trường hợp người dùng không có yêu cầu gì mặc định câu lệnh trong default sẽ chạy
                break;
        }
    }


    private void goStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. StudentDao.getListStudent(): lấy tất cả dữ liệu trong list và gán vào 1 biến: studentList
        request.setAttribute("studentList", StudentDao.getListStudent());
        //2. Sau khi gán tất cả dữ liệu vào biến thì chuyển tất cả dữ liệu qua trang list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void registerNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = (int) Math.random() * 1000;
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Student student = new Student(id, name, dateOfBirth);
        StudentDao.save(student);
        request.setAttribute("message", "register complete");
        goStudentList(request, response);
    }

    private void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student = StudentDao.findById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student = StudentDao.findById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id")); //Nhận id từ view truyền sang
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Student student = new Student(id, name, dateOfBirth);
        StudentDao.save(student);
        request.setAttribute("message", "update complete");
        goStudentList(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        StudentDao.deleteById(id);
        request.setAttribute("message", "delete complete");
        goStudentList(request, response);
    }
}
