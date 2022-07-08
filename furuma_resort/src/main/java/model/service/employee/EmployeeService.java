package model.service.employee;

import model.bean.Customer;
import model.bean.Employee;
import model.service.exception.ValidateException;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void add(Employee employee);

    List<String> add(Employee employee, int idPosition, int idEducation, int idDivison, String username) throws ValidateException, ParseException;

    public List<Employee> pagination(int page, int pageSize);

    public long count();
    void update(Employee employee,int idPosition, int idEducation, int idDivision,String userName);

    boolean remove(int id);

    List<Employee> search(String name);

}
