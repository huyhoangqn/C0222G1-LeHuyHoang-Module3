package model.repository.service.type_rent;

import model.bean.TypeRent;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRentRepository {
    private final String GET_ALL_TYPE_RENT = "select * from rent_type";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<TypeRent> getAllTypeRent() {
        List<TypeRent> typeRents = new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TYPE_RENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                double cost = resultSet.getDouble("rent_type_cost");
                TypeRent typeRent = new TypeRent(id, name, cost);
                typeRents.add(typeRent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeRents;
    }
}
