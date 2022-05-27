package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentController", urlPatterns = "")
public class StudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student[] students = new Student[2];
        students[0] = new Student(0, "Hoang", 10, 0);
        students[1] = new Student(1, "Huy", 10, 1);
        request.setAttribute("listStudent", students);
        request.getRequestDispatcher("list_student.jsp").forward(request, response);
    }

}
