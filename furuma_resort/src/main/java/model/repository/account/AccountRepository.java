package model.repository.account;

import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountRepository {
    private static final String LOGIN = "select * from user where user_name=? and password=?";

    DatabaseRepository databaseRepository = new DatabaseRepository();

    public boolean checkLogin(String userName, String password) {

        boolean isValid = false;
        try {
            Connection connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            } else {
                isValid = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
