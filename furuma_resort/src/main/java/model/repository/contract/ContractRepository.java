package model.repository.contract;

import model.bean.*;
import model.repository.DatabaseRepository;
import model.service.customer.CustomerService;
import model.service.customer.CustomerServiceImpl;
import model.service.employee.EmployeeService;
import model.service.employee.EmployeeServiceImpl;
import model.service.service.ServiceService;
import model.service.service.ServiceServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    private static final String GET_ALL = "select *\n" +
            "from contract\n" +
            "         left join customer c on contract.customer_id = c.customer_id\n" +
            "         left join employee e on contract.employee_id = e.employee_id\n" +
            "         left join service s on contract.service_id = s.service_id";
    private static final String INSERT_INTO = "insert into contract(employee_id, customer_id, service_id," +
            " contract_start_date, contract_end_date, contract_deposit, contract_total_money) values (?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select *\n" +
            "from contract\n" +
            "         left join customer c on contract.customer_id = c.customer_id\n" +
            "         left join employee e on contract.employee_id = e.employee_id\n" +
            "         left join service s on contract.service_id = s.service_id WHERE contract.contract_id=?";

    private static final String GET_LIST_BY_CUSTOMER_ID = "select contract.contract_id, employee_id, contract.customer_id, service_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money\n" +
            "from contract inner join customer c on contract.customer_id = c.customer_id where contract.customer_id = ?";

    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();

    public List<Contract> findAll() {
        connection = databaseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                int idEmployee = resultSet.getInt("employee_id");
                Employee employee = employeeService.findById(idEmployee);
                int idCustomer = resultSet.getInt("customer_id");
                Customer customer = customerService.findById(idCustomer);
                int idService = resultSet.getInt("service_id");
                Service service = serviceService.findById(idService);
                String dateStart = resultSet.getString("contract_start_date");
                String dateEnd = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double totalMoney = resultSet.getDouble("contract_total_money");
                Contract contract = new Contract(id, dateStart, dateEnd, deposit, totalMoney, employee, customer, service);
                contracts.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contracts;

    }

    public void insertContract(Contract contract) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, contract.getEmployee().getId());
            preparedStatement.setInt(2, contract.getCustomer().getIdCustomer());
            preparedStatement.setInt(3, contract.getService().getIdService());
            preparedStatement.setString(4, contract.getDateStart());
            preparedStatement.setString(5, contract.getDateEnd());
            preparedStatement.setDouble(6, contract.getDeposit());
            preparedStatement.setDouble(7, contract.getTotalMoney());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertContract(Contract contract, int idEmployee, int idCustomer, int idService) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, idEmployee);
            preparedStatement.setInt(2, idCustomer);
            preparedStatement.setInt(3, idService);
            preparedStatement.setString(4, contract.getDateStart());
            preparedStatement.setString(5, contract.getDateEnd());
            preparedStatement.setDouble(6, contract.getDeposit());
            preparedStatement.setDouble(7, contract.getTotalMoney());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Contract findById(int id) {
        Connection connection = databaseRepository.connectDataBase();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("contract_id");
                int idEmployee = resultSet.getInt("employee_id");
                Employee employee = employeeService.findById(idEmployee);
                int idCustomer = resultSet.getInt("customer_id");
                Customer customer = customerService.findById(idCustomer);
                int idService = resultSet.getInt("service_id");
                Service service = serviceService.findById(idService);
                String dateStart = resultSet.getString("contract_start_date");
                String dateEnd = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double totalMoney = resultSet.getDouble("contract_total_money");
                contract = new Contract(id1, dateStart, dateEnd, deposit, totalMoney, employee, customer, service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return contract;
    }


    public List<Contract> getListByCustomerId(int customerId) {

        Connection connection = databaseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_BY_CUSTOMER_ID);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("contract_id");
                int idEmployee = resultSet.getInt("employee_id");
                Employee employee = employeeService.findById(idEmployee);
                int idCustomer = resultSet.getInt("customer_id");
                Customer customer = customerService.findById(idCustomer);
                int idService = resultSet.getInt("service_id");
                Service service = serviceService.findById(idService);
                String dateStart = resultSet.getString("contract_start_date");
                String dateEnd = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double totalMoney = resultSet.getDouble("contract_total_money");
                Contract contract = new Contract(id1, dateStart, dateEnd, deposit, totalMoney, employee, customer, service);
                contracts.add(contract);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return contracts;


    }

//
//
//    public void add(Contract contract) {
//        contracts.put(contract.getId(), contract);
//    }
//
//
//    public void update(int id, Contract contract) {
//        contracts.put(id, contract);
//    }
//
//    public Contract remove(int id) {
//        contracts.remove(id);
//        return null;
//    }
//
//
//    public List<Contract> search(String name) {
//        return findAll().stream().filter(ob -> ob.getName().contains(name)).collect(Collectors.toList());
//    }
}
