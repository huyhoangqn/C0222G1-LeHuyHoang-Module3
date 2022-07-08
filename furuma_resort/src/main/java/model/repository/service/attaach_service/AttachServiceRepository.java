package model.repository.service.attaach_service;

import model.bean.AttachService;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository {
    private static final String FIND_BY_ID = "select * from attach_service where attach_service_id=?";
    private static final String GET_ALL = "select * from attach_service";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public AttachService findById(int id) {
        Connection connection = databaseRepository.connectDataBase();
        AttachService attachService = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("attach_service_id");
                String name = resultSet.getString("attach_service_name");
                double cost = resultSet.getDouble("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                attachService = new AttachService(id1, name, cost, unit, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return attachService;
    }

    public List<AttachService> findAll() {
        Connection connection = databaseRepository.connectDataBase();
        List<AttachService> attachServices = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("attach_service_id");
                String name = resultSet.getString("attach_service_name");
                double cost = resultSet.getDouble("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                AttachService attachService = new AttachService(id, name, cost, unit, status);
                attachServices.add(attachService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachServices;
    }
}
