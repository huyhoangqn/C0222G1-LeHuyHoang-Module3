package model.service.sach;

import model.bean.Sach;
import model.repository.SachRepo;

import java.sql.SQLException;
import java.util.List;

public class SachImpl implements ISach {
    SachRepo sachRepo = new SachRepo();

    @Override
    public List<Sach> findAll() throws SQLException {
        return sachRepo.findAll();
    }

    @Override
    public Sach findById(String id) throws SQLException {
        return sachRepo.findById(id);
    }
}
