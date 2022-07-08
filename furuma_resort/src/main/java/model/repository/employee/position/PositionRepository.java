package model.repository.employee.position;

import model.bean.Position;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private final String GET_ALL_POSITION = "select * from position ";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<Position> getAllPosition() {
        List<Position> positions=new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("position_name");
                Position position = new Position(id, name);
                positions.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positions;
    }
}
