package model.repository;

import model.bean.BenhAn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepo {
    private static final String GET_ALL = "select * from benh_an;";
    private static final String UPDATE = "UPDATE `benh_an` SET `reason` = ? WHERE id = ? ;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try {
            Connection connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhAn = resultSet.getString("id");
                String lyDo = resultSet.getString("reason");
                BenhAn benhAn = new BenhAn(maBenhAn, lyDo);
                benhAnList.add(benhAn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAnList;
    }

    public void update(BenhAn benhAn) throws SQLException {
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, benhAn.getLyDoNhapVien());
        preparedStatement.setString(2, benhAn.getMaBanhAn());
        preparedStatement.executeUpdate();
    }
}
