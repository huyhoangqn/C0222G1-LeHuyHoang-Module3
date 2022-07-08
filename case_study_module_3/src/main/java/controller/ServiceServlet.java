package controller;

import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;
import model.service.service.ServiceService;
import model.service.service.ServiceServiceImpl;
import model.service.type_rent.TypeRentServiceImpl;
import model.service.type_service.TypeServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    TypeServiceServiceImpl typeServiceService = new TypeServiceServiceImpl();
    TypeRentServiceImpl typeRentService = new TypeRentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addService(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TypeService> typeServices = typeServiceService.getAll();
            List<TypeRent> typeRents = typeRentService.getAll();
            request.setAttribute("typeServices", typeServices);
            request.setAttribute("typeRents", typeRents);
            request.setAttribute("action", "create");
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAll();
        try {
            request.setAttribute("serviceList", serviceList);
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameService = request.getParameter("nameService");
        int areaService = Integer.parseInt(request.getParameter("areaService"));
        double costService = Double.parseDouble(request.getParameter("costService"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeopleService"));
        int idTypeRent = Integer.parseInt(request.getParameter("idTypeRent"));
        int idTypeService = Integer.parseInt(request.getParameter("idTypeService"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        String areaPool = !request.getParameter("areaPool").isEmpty() ? request.getParameter("areaPool") : null;
        String numberOfFloors = !request.getParameter("numberOfFloors").isEmpty() ? request.getParameter("numberOfFloors") : null;
//
        Service service = new Service(nameService, areaService, costService, maxPeople, standardRoom, descriptionOtherConvenience, areaPool, numberOfFloors);
        serviceService.add(service, idTypeRent, idTypeService);
        request.setAttribute("mess", "Them thanh cong!");
        request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
    }
}
