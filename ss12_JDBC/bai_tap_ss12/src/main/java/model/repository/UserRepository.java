package model.repository;

import model.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    DatabaseRepository databaseRepository = new DatabaseRepository();
    private static final String SELECT_ALL_USER = "select * from user1";
    private static final String ODER_BY = "select * from user1\n" +
            "order by ";
    private static final String SELECT_USER_BY_COUNTRY = "select * from user1\n" +
            "where country like ? ";

    public List<User> selectAllUser() {
        Connection connection = databaseRepository.connectDataBase();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public List<User> searchUserByCountry(String country) {
        Connection connection = databaseRepository.connectDataBase();
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                user = new User(id1, name, email, country1);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public List<User> sort(String name) {
        Connection connection = databaseRepository.connectDataBase();
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ODER_BY + name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id1, name1, email, country);
                userList.add(user);
                System.out.println(name1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
