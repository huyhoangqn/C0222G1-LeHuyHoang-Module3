package model.service.employee;

import model.bean.Employee;
import model.repository.employee.EmployeeRepository;
import model.service.validators.EmployeeValidator;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeValidator employeeValidator = new EmployeeValidator();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<String> add(Employee employee) {
        List<String> errors = employeeValidator.validateEmployee(employee);

        if (errors.isEmpty()) {
            employeeRepository.insertEmployee(employee);
        }
        return errors;
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public boolean remove(int id) {
        return employeeRepository.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> search(String name, int idPosotion, int idEducation) {
        return employeeRepository.Search(name, idPosotion, idEducation);
    }

}
