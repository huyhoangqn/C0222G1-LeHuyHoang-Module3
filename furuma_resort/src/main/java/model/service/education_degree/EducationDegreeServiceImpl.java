package model.service.education_degree;

import model.bean.EducationDegree;
import model.repository.employee.education_degree.EducationDegreeRepository;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService{
    EducationDegreeRepository degreeRepository=new EducationDegreeRepository();
    @Override
    public List<EducationDegree> getAll() {
        return degreeRepository.getAllEducationDegree();
    }
}
