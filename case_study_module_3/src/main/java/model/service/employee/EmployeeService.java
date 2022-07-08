package model.service.employee;

import model.bean.Employee;
import model.service.exception.ValidateException;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    List<String> add(Employee employee) throws ValidateException, ParseException;

    void update(Employee employee);

    boolean remove(int id);

    Employee findById(int id);
    List<Employee> search(String name, int idPosotion, int idEducation);


}
