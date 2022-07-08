package model.service.employee;

import model.bean.Employee;
import model.repository.employee.EmployeeRepository;
import model.service.exception.ValidateException;
import model.service.validators.EmployeeValidator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeValidator employeeValidator = new EmployeeValidator();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public List<String> add(Employee employee, int idPosition, int idEducation, int idDivison, String username) throws ValidateException, ParseException {
        List<String> errors = employeeValidator.validateEmployee(employee);

        if (errors.isEmpty()) {
            employeeRepository.insertEmployee(employee, idPosition, idEducation, idDivison, username);
        }
        return errors;



    }

    @Override
    public List<Employee> pagination(int page, int pageSize) {
        return employeeRepository.getListByPagination(page, pageSize);
    }

    @Override
    public long count() {
        return employeeRepository.countAll();
    }

    @Override
    public void update(Employee employee, int idPosition, int idEducation, int idDivision, String userName) {
        employeeRepository.update(employee, idPosition, idEducation, idDivision, userName);
    }


    @Override
    public boolean remove(int id) {
        return employeeRepository.remove(id);
    }

    @Override
    public List<Employee> search(String name) {
        return employeeRepository.search(name);
    }
}
