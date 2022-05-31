package service.impl;

import model.Student;
import repository.IStudentRepo;
import repository.impl.StudentRepo;
import service.IStudentService;

import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {

    IStudentRepo studentRepo = new StudentRepo();

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Map<String, String> save(Student student) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
