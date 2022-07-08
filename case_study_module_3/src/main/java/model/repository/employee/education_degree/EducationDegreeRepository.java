package model.repository.employee.education_degree;

import model.bean.EducationDegree;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository {
    private final String TRINH_DO = "select * from trinh_do ";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<EducationDegree> getAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TRINH_DO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                EducationDegree educationDegree = new EducationDegree(id, name);
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }
}
