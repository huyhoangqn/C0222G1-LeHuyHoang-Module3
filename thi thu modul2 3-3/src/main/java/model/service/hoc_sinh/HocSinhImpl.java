package model.service.hoc_sinh;

import model.bean.HocSinh;
import model.repository.HocSinhRepo;

import java.sql.SQLException;
import java.util.List;

public class HocSinhImpl implements IHocSinh {
    HocSinhRepo hocSinhRepo = new HocSinhRepo();

    @Override
    public List<HocSinh> findAll() throws SQLException {
        return hocSinhRepo.findAll();
    }
}
