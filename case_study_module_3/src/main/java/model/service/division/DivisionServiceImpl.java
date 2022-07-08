package model.service.division;

import model.bean.Division;
import model.repository.employee.division.DivisionRepository;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public List<Division> getAll() {
        return divisionRepository.getAllDivision();
    }
}
