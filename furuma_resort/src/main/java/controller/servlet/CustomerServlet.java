package controller.servlet;

import model.bean.Customer;
import model.bean.TypeCustomer;
import model.service.contract.ContractServiceImpl;
import model.service.customer.CustomerServiceImpl;
import model.service.type_customer.TypeCustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    TypeCustomerServiceImpl typeCustomerService = new TypeCustomerServiceImpl();
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
                addCustomer(request, response);
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
            case "edit": {
                showFormEdit(request, response);
                break;
            }
            case "delete": {
                deleteCustomer(request, response);
                break;
            }
            case "search": {
                search(request, response);
                break;
            }
            case "hasContract": {
                customerUsingService(request, response);
                break;
            }
            default:
                break;
        }
    }

    private void customerUsingService(HttpServletRequest request, HttpServletResponse response) {
        try {

//            int page;
//            request.getParameter("page");
//            int pageSize;
//            request.getParameter("size");
//            try {
//                page = Integer.parseInt(request.getParameter("page"));
//            } catch (Exception e) {
//                page = 1;
//            }
//            try {
//                pageSize = Integer.parseInt(request.getParameter("pageSize"));
//            } catch (Exception e) {
//                pageSize = 8;
//            }
            List<Customer> customers = customerService.getCustomerListHasContract();
            long total = customerService.count();
//            request.setAttribute("action", "list");
//            request.setAttribute("total", total);
//            request.setAttribute("page", page);
//            request.setAttribute("pageSize", pageSize);
            customers = customers.stream().map(ob -> {
                ob.setContractList(contractService.getListByCustomerId(ob.getIdCustomer()));
                return ob;
            }).collect(Collectors.toList());
            request.setAttribute("list", customers);
            request.getRequestDispatcher("view/customer/customer_using_service.jsp").forward(request, response);

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


    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customers = customerService.search(name);
        request.setAttribute("list", customers);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.findById(id));
        request.setAttribute("typeCustomers", typeCustomerService.getAll());
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String nameCustomer = request.getParameter("nameCustomer");
        String birthdayCustomer = request.getParameter("birthdayCustomer");
        String idCardCustomer = request.getParameter("idCardCustomer");
        int genderCustomer = Integer.parseInt(request.getParameter("genderCustomer"));
        String phoneCustomer = request.getParameter("phoneCustomer");
        String emailCustomer = request.getParameter("emailCustomer");
        String addressCustomer = request.getParameter("addressCustomer");
        Customer customer = new Customer(idCustomer, nameCustomer, birthdayCustomer, idCardCustomer, genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
        customerService.update(customer, idTypeCustomer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.remove(id);
            response.sendRedirect("/customer");
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TypeCustomer> typeCustomers = typeCustomerService.getAll();
            request.setAttribute("action", "create");
            request.setAttribute("typeCustomers", typeCustomers);
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String nameCustomer = request.getParameter("nameCustomer");
        String birthdayCustomer = request.getParameter("birthdayCustomer");
        String idCardCustomer = request.getParameter("idCardCustomer");
        int genderCustomer = Integer.parseInt(request.getParameter("genderCustomer"));
        String phoneCustomer = request.getParameter("phoneCustomer");
        String emailCustomer = request.getParameter("emailCustomer");
        String addressCustomer = request.getParameter("addressCustomer");

        Customer customer = new Customer(nameCustomer, birthdayCustomer, idCardCustomer,
                genderCustomer, phoneCustomer, emailCustomer, addressCustomer);

        List<String> errors = customerService.add(customer, idTypeCustomer);

        if (errors.isEmpty()) {
            errors.add("create success");
        }
        request.setAttribute("errors", errors);
        try {
            request.setAttribute("customer", customer);
            request.setAttribute("typeCustomers", typeCustomerService.getAll());
            request.setAttribute("idTypeCustomer",idTypeCustomer);
//            request.setAttribute("action","create");
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }



    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("action", "list");
            int page;
            request.getParameter("page");
            int pageSize;
            request.getParameter("size");
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                page = 1;
            }
            try {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            } catch (Exception e) {
                pageSize = 8;
            }
            List<Customer> customers = customerService.pagination(page, pageSize);
            long total = customerService.count();
            request.setAttribute("action", "list");
            request.setAttribute("total", total);
            request.setAttribute("page", page);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("list", customers);
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);

        }

    }
}
