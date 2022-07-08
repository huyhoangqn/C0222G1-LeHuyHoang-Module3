package controller.servlet;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.service.attach_service.AttachServiceImpl;
import model.service.attach_service.AttachServiceService;
import model.service.contract.ContractServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractServiceImpl contractService = new ContractServiceImpl();

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
                addContract(request, response);
                break;
            }
            case "edit": {
//                update(request, response);
                break;
            }
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
//                showFormEdit(request, response);
                break;
            }
            case "delete": {
//                deleteContract(request, response);
                break;
            }
        }
    }

//    private void deleteContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            contractService.remove(id);
//            response.sendRedirect("/contract");
//        } catch (Exception e) {
//            request.getRequestDispatcher("view/404.jsp").forward(request, response);
//
//        }
//
//    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "create");

            request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }
    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
            int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
            int idService = Integer.parseInt(request.getParameter("idService"));
            String dateStart = request.getParameter("dateStart");
            String dateEnd = request.getParameter("dateEnd");
            double deposit = Double.parseDouble(request.getParameter("deposit"));
            double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
            Contract contract = new Contract(dateStart, dateEnd, deposit, totalMoney);
            contractService.add(contract, idEmployee, idCustomer, idService);
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("contract", contractService.findById(id));
//        try {
//            request.getRequestDispatcher("view/contract/edit.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void update(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        Contract contract = new Contract(id, name);
//        contractService.update(contract.getId(), contract);
//        try {
//            response.sendRedirect("/contract");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "list");

            request.setAttribute("contracts", contractService.findAll());
            request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }
}
