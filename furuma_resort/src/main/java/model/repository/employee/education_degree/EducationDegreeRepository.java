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
    private final String GET_ALL_EDUCATION_DEGREE = "select * from education_degree ";
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<EducationDegree> getAllEducationDegree() {
        List<EducationDegree> educationDegrees=new ArrayList<>();
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(id, name);
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }
}
