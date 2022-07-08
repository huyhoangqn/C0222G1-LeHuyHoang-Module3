package model.repository.service.type_service;

import model.bean.TypeService;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceRepository {
    private final String GET_ALL_TYPE_SERVICE = "select * from service_type";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<TypeService> getAllTypeService() {
        List<TypeService> typeServices=new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TYPE_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                TypeService typeService = new TypeService(id, name);
                typeServices.add(typeService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeServices;
    }
}
