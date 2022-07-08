package model.repository.employee.division;

import model.bean.Division;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository {
    private final String GET_ALL_DIVISION = "select * from division ";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<Division> getAllDivision() {
        List<Division> divisions=new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("divison_id");
                String name = resultSet.getString("divison_name");
                Division division = new Division(id, name);
                divisions.add(division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }
}
