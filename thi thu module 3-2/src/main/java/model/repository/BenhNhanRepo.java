package model.repository;

import model.bean.BenhAn;
import model.bean.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BenhNhanRepo {
    private static final String GET_ALL = "select * from benh_nhan left join benh_an a on benh_nhan.idBenhAn = a.id;";
    private static final String DELETE = "DELETE FROM benh_nhan WHERE id=?;";
    private static final String GET_OB = "select * from benh_nhan left join benh_an a on benh_nhan.idBenhAn = a.id where benh_nhan.id = ?;";
    private static final String UPDATE = "UPDATE `benh_nhan` SET `name` = ?, `datein` = ?, `dateout` = ? WHERE id = ?;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<BenhNhan> findAll() throws SQLException {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maBenhNhan = resultSet.getString("id");
            String tenBenhNhan = resultSet.getString("name");
            Date ngayNhap = resultSet.getDate("datein");
            Date ngayXuat = resultSet.getDate("dateout");


            String maBenhAn = resultSet.getString("idBenhAn");
            String lyDo = resultSet.getString("a.reason");
            BenhAn benhAn = new BenhAn(maBenhAn, lyDo);
            BenhNhan benhNhan = new BenhNhan(maBenhNhan, tenBenhNhan, ngayNhap, ngayXuat, benhAn);
            benhNhanList.add(benhNhan);
        }
        return benhNhanList;
    }

    public void delete(String maBenhNhan) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, maBenhNhan);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public BenhNhan findById(String id) throws SQLException {
        connection = databaseRepository.connectDataBase();
        BenhNhan benhNhan = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_OB);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maBenhNhan = resultSet.getString("id");
            String tenBenhNhan = resultSet.getString("name");
            Date ngayNhap = resultSet.getDate("datein");
            Date ngayXuat = resultSet.getDate("dateout");


            String maBenhAn = resultSet.getString("idBenhAn");
            String lyDo = resultSet.getString("a.reason");
            BenhAn benhAn = new BenhAn(maBenhAn, lyDo);
            benhNhan = new BenhNhan(maBenhNhan, tenBenhNhan, ngayNhap, ngayXuat, benhAn);
        }
        return benhNhan;
    }

    public void update(BenhNhan benhNhan) throws SQLException {
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, benhNhan.getTenBenhNham());
        preparedStatement.setDate(2, (java.sql.Date) benhNhan.getNgayNhap());
        preparedStatement.setDate(3, (java.sql.Date) benhNhan.getNgayXuat());
        preparedStatement.setString(4, benhNhan.getMaBenhNhan());
        preparedStatement.executeUpdate();
    }
}
