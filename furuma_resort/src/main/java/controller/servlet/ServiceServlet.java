package controller.servlet;

import model.bean.*;
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
    ServiceServiceImpl serviceService = new ServiceServiceImpl();
    TypeServiceServiceImpl typeServiceService = new TypeServiceServiceImpl();
    TypeRentServiceImpl typeRentService = new TypeRentServiceImpl();

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
                addService(request, response);
                break;
            }
            case "edit": {
                update(request, response);
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
    //            case "edit": {
    //                showFormEdit(request, response);
    //                break;
    //            }
    //            case "delete": {
    //                deleteService(request, response);
    //                break;
    //            }
                default:
                    break;
            }
    }

//    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("service", serviceService.findById(id));
//        try {
//            request.getRequestDispatcher("view/service/edit.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            serviceService.remove(id);
//            response.sendRedirect("/service");
//        } catch (Exception e) {
//            request.getRequestDispatcher("view/404.jsp").forward(request, response);
//
//        }
//
//    }

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

    private void addService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String nameService = request.getParameter("nameService");
            Integer areaService = Integer.parseInt(request.getParameter("areaService"));
            Double costService = Double.parseDouble(request.getParameter("costService"));
            Integer maxPeople = Integer.parseInt(request.getParameter("maxPeopleService"));
            Integer idTypeRent = Integer.parseInt(request.getParameter("idTypeRent"));
            Integer idTypeService = Integer.parseInt(request.getParameter("idTypeService"));
            String standardRoom = request.getParameter("standardRoom");
            String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            Double areaPool = !request.getParameter("areaPool").isEmpty() ? Double.parseDouble(request.getParameter("areaPool")) : null;
            Integer numberOfFloors = !request.getParameter("numberOfFloors").isEmpty() ? Integer.parseInt(request.getParameter("numberOfFloors")) : null;
            Service service = new Service(nameService, areaService, costService, maxPeople, standardRoom, descriptionOtherConvenience, areaPool, numberOfFloors);
            serviceService.add(service, idTypeRent, idTypeService);
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "list");
            request.setAttribute("list", serviceService.findAll());
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        Service service = new Service(id, name);
//        serviceService.update(service.getId(), service);
//        try {
//            response.sendRedirect("/service");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
