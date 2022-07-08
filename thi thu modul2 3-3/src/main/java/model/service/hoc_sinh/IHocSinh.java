package model.service.hoc_sinh;

import model.bean.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinh {
    List<HocSinh> findAll() throws SQLException;
}
