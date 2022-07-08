package model.repository;

import model.bean.HocSinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhRepo {
    private static final String GET_ALL = "select * from hoc_sinh;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<HocSinh> findAll() throws SQLException {
        List<HocSinh> hocSinhList = new ArrayList<>();
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maHocSinh = resultSet.getString("id");
            String tenHocSinh = resultSet.getString("name");
            String lop = resultSet.getString("class");


            HocSinh hocSinh = new HocSinh(maHocSinh, tenHocSinh, lop);
            hocSinhList.add(hocSinh);
        }
        return hocSinhList;
    }
}
