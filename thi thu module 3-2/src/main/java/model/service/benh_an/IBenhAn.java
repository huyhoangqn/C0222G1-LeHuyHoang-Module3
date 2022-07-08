package model.service.benh_an;

import model.bean.BenhAn;

import java.sql.SQLException;
import java.util.List;

public interface IBenhAn {
    List<BenhAn> fillAll();
    void update (BenhAn benhAn) throws SQLException;
}
