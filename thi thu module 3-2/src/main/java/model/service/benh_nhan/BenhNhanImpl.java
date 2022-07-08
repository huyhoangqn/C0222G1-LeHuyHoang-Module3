package model.service.benh_nhan;

import model.bean.BenhNhan;
import model.repository.BenhNhanRepo;
import model.service.validators.BenhNhanValidator;

import java.sql.SQLException;
import java.util.List;

public class BenhNhanImpl implements IBenhNhan {
    BenhNhanRepo benhNhanRepo = new BenhNhanRepo();
    BenhNhanValidator benhNhanValidator = new BenhNhanValidator();

    @Override
    public List<BenhNhan> fillAll() throws SQLException {
        return benhNhanRepo.findAll();
    }

    @Override
    public void delete(String maBenhNhan) {
        benhNhanRepo.delete(maBenhNhan);
    }

    @Override
    public BenhNhan findById(String id) throws SQLException {
        return benhNhanRepo.findById(id);
    }

    @Override
    public void update(BenhNhan benhNhan) throws SQLException {
        benhNhanRepo.update(benhNhan);
    }

    @Override
    public List<String> add(BenhNhan benhNhan) throws SQLException {
        List<String> errors = benhNhanValidator.validatorBenhNhan(benhNhan);
        if (errors.isEmpty()) {
            benhNhanRepo.update(benhNhan);
        }
        return errors;
    }
}
