package repository;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentRepo {
    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void delete(int id);
}
