package model.repository;

import model.bean.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepo {
    private static final String GET_ALL = "select * from sach;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    private static final String GET_OB = "select * from sach where id =?;";
    Connection connection;

    public List<Sach> findAll() throws SQLException {
        List<Sach> sachList = new ArrayList<>();
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maSach = resultSet.getString("id");
            String tenSach = resultSet.getString("name");
            String tacGia = resultSet.getString("author");
            String moTa = resultSet.getString("desc");
            int soluong = resultSet.getInt("amount");

            Sach sach = new Sach(maSach, tenSach, tacGia, moTa, soluong);
            sachList.add(sach);
        }
        return sachList;
    }

    public Sach findById(String id) throws SQLException {
        Sach sach = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_OB);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maSach = resultSet.getString("id");
            String tenSach = resultSet.getString("name");
            String tacGia = resultSet.getString("author");
            String moTa = resultSet.getString("desc");
            int soluong = resultSet.getInt("amount");
            sach = new Sach(maSach, tenSach, tacGia, moTa, soluong);
        }
        return sach;
    }
}
