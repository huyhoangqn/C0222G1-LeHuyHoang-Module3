package model.repository.customer.type_customer;

import model.bean.TypeCustomer;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCustomerRepository {
    private final String GET_ALL_TYPE_CUSTOMER = "select * from customer_type";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<TypeCustomer> getAllTypeCustomer() {
        List<TypeCustomer> typeCustomers=new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TYPE_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                TypeCustomer typeCustomer = new TypeCustomer(id, name);
                typeCustomers.add(typeCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeCustomers;
    }
}
