package model.service.benh_nhan;

import model.bean.BenhNhan;

import java.sql.SQLException;
import java.util.List;

public interface IBenhNhan {
    List<BenhNhan> fillAll() throws SQLException;
    void delete(String maBenhNhan);
    BenhNhan findById(String id) throws SQLException;
    void update(BenhNhan benhNhan) throws SQLException;

    List<String> add(BenhNhan benhNhan) throws SQLException;

}
