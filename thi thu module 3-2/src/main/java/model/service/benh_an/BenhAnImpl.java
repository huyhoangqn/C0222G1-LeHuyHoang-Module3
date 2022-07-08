package model.service.benh_an;

import model.bean.BenhAn;
import model.repository.BenhAnRepo;

import java.sql.SQLException;
import java.util.List;

public class BenhAnImpl implements IBenhAn {
    BenhAnRepo benhAnRepo = new BenhAnRepo();


    @Override
    public List<BenhAn> fillAll() {
        return benhAnRepo.findAll();
    }

    @Override
    public void update(BenhAn benhAn) throws SQLException {
        benhAnRepo.update(benhAn);
    }
}
