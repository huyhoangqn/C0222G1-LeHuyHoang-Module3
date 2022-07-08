package model.repository;

import model.bean.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static final String GET_ALL = "SELECT * FROM category";
    private static final String FIND_BY_ID = "SELECT * FROM category WHERE id=?";


    DatabaseRepository databaseRepository = new DatabaseRepository();

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }

    public Category findById(int id) {
        Category category = null;
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt(category.getId());
                String name = resultSet.getString(category.getName());
                category = new Category(id1, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return category;
    }
}
