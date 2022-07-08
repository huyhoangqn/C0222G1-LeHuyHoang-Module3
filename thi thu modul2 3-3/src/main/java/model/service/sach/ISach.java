package model.service.sach;

import model.bean.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISach {
    List<Sach> findAll() throws SQLException;

    Sach findById(String id) throws SQLException;
}
