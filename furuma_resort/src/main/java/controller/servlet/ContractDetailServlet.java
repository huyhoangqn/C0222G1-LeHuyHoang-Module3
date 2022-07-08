package controller.servlet;

import model.bean.ContractDetail;
import model.service.attach_service.AttachServiceImpl;
import model.service.attach_service.AttachServiceService;
import model.service.contract.contract_detail.ContractDetailService;
import model.service.contract.contract_detail.ContractDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/detail")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    AttachServiceService attachServiceService = new AttachServiceImpl();

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
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("action", "create");
            request.setAttribute("attachServices", attachServiceService.findAll());
            request.setAttribute("idContract",Integer.parseInt(request.getParameter("idContract")));
            request.getRequestDispatcher("view/contract_detail/create.jsp").forward(request, response);

        } catch (Exception e) {
            try {
                request.getRequestDispatcher("view/404.jsp").forward(request, response);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idContract = Integer.parseInt(request.getParameter("idContract"));
            request.setAttribute("idContract", idContract);
            request.setAttribute("contractDetails", contractDetailService.findByContractId(idContract));
            request.getRequestDispatcher("view/contract_detail/list.jsp").forward(request, response);
        } catch (Exception e) {
            try {
                request.getRequestDispatcher("view/404.jsp").forward(request, response);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idAttach = Integer.parseInt(request.getParameter("idAttach"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(quantity);
        contractDetailService.add(contractDetail, idContract, idAttach);
        try {
            response.sendRedirect("/detail?action=list&idContract="+ idContract);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
