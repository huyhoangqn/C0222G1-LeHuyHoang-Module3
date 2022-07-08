package controller;

import model.bean.Employee;
import model.service.division.DivisionServiceImpl;
import model.service.education_degree.EducationDegreeServiceImpl;
import model.service.employee.EmployeeServiceImpl;
import model.service.position.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    PositionServiceImpl positionService = new PositionServiceImpl();
    EducationDegreeServiceImpl degreeService = new EducationDegreeServiceImpl();
    DivisionServiceImpl divisionService = new DivisionServiceImpl();

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
                addEmployee(request, response);
                break;
            }
            case "edit": {
                update(request, response);
                break;
            }
            case "search":
                search(request, response);
                break;
            default:
                break;
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
                deleteEmployee(request, response);
                break;
            }
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        try {
            request.setAttribute("positions", positionService.getAll());
            request.setAttribute("educationDegrees", degreeService.getAll());
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("positions", positionService.getAll());
            request.setAttribute("educationDegrees", degreeService.getAll());
            request.setAttribute("divisions", divisionService.getAll());
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }
    }


    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            employeeService.remove(id);
            response.sendRedirect("/employee");
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }


    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = null;
        try {
            String name = request.getParameter("name");
            int idPosition = Integer.parseInt(request.getParameter("idPosition"));
            int idEducation = Integer.parseInt(request.getParameter("idEducation"));
            int idDivision = Integer.parseInt(request.getParameter("idDivision"));
            String birthday = request.getParameter("birthday");
            String idCard = request.getParameter("idCard");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            employee = new Employee(name, birthday, idCard, salary, phone, email,
                    address, idPosition, idEducation, idDivision);
            List<String> errors = employeeService.add(employee);
            if (errors.isEmpty()) {
                request.setAttribute("message", "Employee created");
            } else {
                request.setAttribute("errors", errors);
            }


        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            e.printStackTrace();
        } finally {
            request.setAttribute("positions", positionService.getAll());
            request.setAttribute("educationDegrees", degreeService.getAll());
            request.setAttribute("divisions", divisionService.getAll());
            showList(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("positions", positionService.getAll());
        request.setAttribute("educationDegrees", degreeService.getAll());
        request.setAttribute("divisions", divisionService.getAll());
        request.setAttribute("employee", employeeService.findById(id));
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            String idCard = request.getParameter("idCard");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int idPosition = Integer.parseInt(request.getParameter("idPosition"));
            int idEducation = Integer.parseInt(request.getParameter("idEducation"));
            int idDivision = Integer.parseInt(request.getParameter("idDivision"));

            Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, idPosition, idEducation, idDivision);
            employeeService.update(employee);
            request.setAttribute("message", "sửa thành công!");
            showList(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducation = Integer.parseInt(request.getParameter("idEducation"));
        List<Employee> employeeList = employeeService.search(name, idPosition, idEducation);
        try {
            request.setAttribute("positions", positionService.getAll());
            request.setAttribute("educationDegrees", degreeService.getAll());
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }
}
