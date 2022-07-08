package model.repository.customer;

import model.bean.Customer;
import model.bean.TypeCustomer;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    DatabaseRepository databaseRepository = new DatabaseRepository();
    private static final String SELECT_ALL_CUSTOMER = "select *\n" +
            "from customer\n" +
            "         left join customer_type ct on customer.customer_type_id = ct.customer_type_id;";

    private static final String COUNT_ALL = "SELECT count(*) as count from customer";

    private static final String PAGINATION = "select *\n" +
            "from customer\n" +
            "         left join customer_type ct on customer.customer_type_id = ct.customer_type_id limit ? offset ?";

    private static String SEARCH = "select * from customer left join customer_type ct on customer.customer_type_id = ct.customer_type_id " +
            "   where customer_name like ?\n " +
            "   or customer_id_card like ?\n " +
            "   or customer_address like ?\n " +
            "   or customer_email like ?\n " +
            "   or customer_phone like ? ";
    private static final String INSERT_INTO = "insert into customer(customer_type_id, customer_name, customer_birthday, customer_id_card, customer_gender,\n" +
            "customer_phone, customer_email, customer_address) values (?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from customer" +
            " left join customer_type ct on customer.customer_type_id = ct.customer_type_id WHERE customer.customer_id=?";

    private static final String UPDATE = "UPDATE customer t SET " +
            " t.customer_type_id=?, t.customer_name = ?, t.customer_birthday = ?, " +
            " t.customer_id_card = ?, t.customer_gender = ?, t.customer_phone = ?, " +
            " t.customer_email = ?, t.customer_address = ? WHERE t.customer_id = ? ";
    private static final String DELETE = "DELETE FROM customer WHERE customer_id = ? ";
    private static final String SELECT_CUSTOMER_USING = "select customer.customer_id, customer_type_id, customer_name, customer_birthday, customer_id_card, customer_gender, customer_phone, customer_email, customer_address from customer\n" +
            "            inner join contract c on customer.customer_id = c.customer_id\n" +
            "            where c.contract_end_date <date (now())\n" +
            "            group by customer_id";
    private static final String CONTRACT_BY_CUSTOMER = "select contract.contract_id, cd.contract_detail_id, attach_service_name, contract_start_date, contract_end_date\n" +
            "from contract\n" +
            "         inner join customer c on contract.customer_id = c.customer_id\n" +
            "         inner join contract_detail cd on contract.contract_id = cd.contract_id\n" +
            "         inner join attach_service `as` on cd.attach_service_id = `as`.attach_service_id\n" +
            "where c.customer_id = ?\n";

    public List<Customer> search(String name) {
        Connection connection = databaseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            String fixSearchString = "\'%" + name + "%\'";
            String SQL = SEARCH.replaceAll("\\?", fixSearchString);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String nameTypeCustomer = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer(idTypeCustomer, nameTypeCustomer);
                String nameCustomer = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String idCard = resultSet.getString("customer_id_card");
                int gender = resultSet.getInt("customer_gender");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Customer customer = new Customer(id, typeCustomer, nameCustomer, birthday, idCard, gender, phone, email, address);
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    public void insertCustomer(Customer customer) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, customer.getTypeCustomer().getId());
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setString(3, customer.getBirthdayCustomer());
            preparedStatement.setString(4, customer.getIdCardCustomer());
            preparedStatement.setInt(5, customer.getGenderCustomer());
            preparedStatement.setString(6, customer.getPhoneCustomer());
            preparedStatement.setString(7, customer.getEmailCustomer());
            preparedStatement.setString(8, customer.getAddressCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer, int type) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, type);
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setString(3, customer.getBirthdayCustomer());
            preparedStatement.setString(4, customer.getIdCardCustomer());
            preparedStatement.setInt(5, customer.getGenderCustomer());
            preparedStatement.setString(6, customer.getPhoneCustomer());
            preparedStatement.setString(7, customer.getEmailCustomer());
            preparedStatement.setString(8, customer.getAddressCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Customer> findAll() {
        Connection connection = databaseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String nameTypeCustomer = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer(idTypeCustomer, nameTypeCustomer);
                String nameCustomer = resultSet.getString("customer_name");
                String birthdayCustomer = resultSet.getString("customer_birthday");
                String idCardCustomer = resultSet.getString("customer_id_card");
                int genderCustomer = resultSet.getInt("customer_gender");
                String phoneCustomer = resultSet.getString("customer_phone");
                String emailCustomer = resultSet.getString("customer_email");
                String addressCustomer = resultSet.getString("customer_address");
                Customer customer = new Customer(idCustomer, typeCustomer, nameCustomer, birthdayCustomer, idCardCustomer, genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public List<Customer> getCustomerListHasContract() {
        Connection connection = databaseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_USING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
//                String nameTypeCustomer = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer();
                String nameCustomer = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String idCard = resultSet.getString("customer_id_card");
                int gender = resultSet.getInt("customer_gender");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");

                Customer customer = new Customer(id, typeCustomer, nameCustomer, birthday, idCard, gender, phone, email, address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


    public Customer findById(int id) {
        Connection connection = databaseRepository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String nameTypeCustomer = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer(idTypeCustomer, nameTypeCustomer);
                String nameCustomer = resultSet.getString("customer_name");
                String birthdayCustomer = resultSet.getString("customer_birthday");
                String idCardCustomer = resultSet.getString("customer_id_card");
                int genderCustomer = resultSet.getInt("customer_gender");
                String phoneCustomer = resultSet.getString("customer_phone");
                String emailCustomer = resultSet.getString("customer_email");
                String addressCustomer = resultSet.getString("customer_address");
                customer = new Customer(idCustomer, typeCustomer, nameCustomer, birthdayCustomer, idCardCustomer, genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return customer;
    }

    public void update(Customer customer, int type) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, type);
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setString(3, customer.getBirthdayCustomer());
            preparedStatement.setString(4, customer.getIdCardCustomer());
            preparedStatement.setInt(5, customer.getGenderCustomer());
            preparedStatement.setString(6, customer.getPhoneCustomer());
            preparedStatement.setString(7, customer.getEmailCustomer());
            preparedStatement.setString(8, customer.getAddressCustomer());
            preparedStatement.setInt(9, customer.getIdCustomer());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public boolean remove(int id) {
        boolean check = false;
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }


    public List<Customer> getListByPagination(int page, int pageSize) {
        Connection connection = databaseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PAGINATION);
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, (page - 1) * pageSize);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String nameTypeCustomer = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer(idTypeCustomer, nameTypeCustomer);
                String nameCustomer = resultSet.getString("customer_name");
                String birthdayCustomer = resultSet.getString("customer_birthday");
                String idCardCustomer = resultSet.getString("customer_id_card");
                int genderCustomer = resultSet.getInt("customer_gender");
                String phoneCustomer = resultSet.getString("customer_phone");
                String emailCustomer = resultSet.getString("customer_email");
                String addressCustomer = resultSet.getString("customer_address");
                Customer customer = new Customer(idCustomer, typeCustomer, nameCustomer, birthdayCustomer, idCardCustomer, genderCustomer, phoneCustomer, emailCustomer, addressCustomer);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;


    }

    public long countAll() {
        Connection connection = databaseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        long count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

}
