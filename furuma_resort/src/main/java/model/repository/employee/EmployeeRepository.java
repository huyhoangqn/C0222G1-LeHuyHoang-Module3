package model.repository.employee;

import model.bean.*;
import model.repository.DatabaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String GET_ALL = "select *from employee " +
            " left join position p on employee.position_id = p.position_id\n" +
            " left join education_degree ed on employee.education_degree_id = ed.education_degree_id\n" +
            " left join division d on employee.division_id = d.divison_id\n" +
            " left join user u on employee.user_name = u.user_name;";
    private static final String INSERT_INTO = "insert into employee (employee_name, position_id, education_degree_id, " +
            " division_id, employee_birthday, employee_id_card,\n" +
            " employee_salary, employee_phone, employee_email, employee_address, user_name)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String COUNT_ALL = "SELECT count(*) as count from employee";
    private static final String PAGINATION = "select *from employee " +
            " left join position p on employee.position_id = p.position_id\n" +
            " left join education_degree ed on employee.education_degree_id = ed.education_degree_id\n" +
            " left join division d on employee.division_id = d.divison_id\n" +
            " left join user u on employee.user_name = u.user_name limit ? offset ?;";
    private static final String FIND_BY_ID = "select * from employee" +
            " left join position p on employee.position_id = p.position_id\n" +
            " left join education_degree ed on employee.education_degree_id = ed.education_degree_id\n" +
            " left join division d on employee.division_id = d.divison_id\n" +
            " left join user u on employee.user_name = u.user_name WHERE employee.employee_id=?";
    private static final String UPDATE = "UPDATE employee t SET " +
            "t.employee_name = ?, t.position_id = ?, t.education_degree_id = ?, " +
            "t.division_id = ?, t.employee_birthday = ?, t.employee_id_card = ?, t.employee_salary = ?, " +
            "t.employee_phone = ?, t.employee_email = ?, t.employee_address = ?, t.user_name=? WHERE t.employee_id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE employee_id = ? ";
    private static String SEARCH = "select * from employee\n" +
            " left join position p on employee.position_id = p.position_id\n" +
            " left join education_degree ed on employee.education_degree_id = ed.education_degree_id\n" +
            " left join division d on employee.division_id = d.divison_id\n" +
            " left join user u on employee.user_name = u.user_name\n" +
            " where employee_name like ?\n" +
            " or employee_phone like ?\n" +
            " or employee_email like ?\n" +
            " or employee_address like ?\n" +
            " or employee_id_card like ?;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<Employee> findAll() {
        connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");

                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                Position position = new Position(idPosition, namePosition);

                int idEducation = resultSet.getInt("Education_degree_id");
                String nameEducation = resultSet.getString("Education_degree_name");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);

                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("divison_name");
                Division division = new Division(idDivision, nameDivision);

                String nameUser = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                User user = new User(nameUser, password);
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }


    public Employee findById(int id) {
        connection = databaseRepository.connectDataBase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                Position position = new Position(idPosition, namePosition);
                int idEducation = resultSet.getInt("Education_degree_id");
                String nameEducation = resultSet.getString("Education_degree_name");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);
                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("divison_name");
                Division division = new Division(idDivision, nameDivision);
                String nameUser = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                User user = new User(nameUser, password);
                employee = new Employee(idEmployee, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }


    public void insertEmployee(Employee employee) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getPosition().getId());
            preparedStatement.setInt(3, employee.getEducationDegree().getId());
            preparedStatement.setInt(4, employee.getDivision().getId());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUser().getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertEmployee(Employee employee, int idPosition, int idEducation, int idDivision, String userName) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, idPosition);
            preparedStatement.setInt(3, idEducation);
            preparedStatement.setInt(4, idDivision);
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> getListByPagination(int page, int pageSize) {
        Connection connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PAGINATION);
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, (page - 1) * pageSize);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                Position position = new Position(idPosition, namePosition);
                int idEducation = resultSet.getInt("Education_degree_id");
                String nameEducation = resultSet.getString("Education_degree_name");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);
                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("divison_name");
                Division division = new Division(idDivision, nameDivision);
                String nameUser = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                User user = new User(nameUser, password);
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;


    }

    public long countAll() {
        Connection connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        long count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;

    }


    public void update(Employee employee, int idPosition, int idEducation, int idDivision, String userName) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, idPosition);
            preparedStatement.setInt(3, idEducation);
            preparedStatement.setInt(4, idDivision);
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, userName);
            preparedStatement.setInt(12, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean remove(int id) {
        boolean check = false;
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }


    public List<Employee> search(String name) {
        Connection connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            String fixSearchString = "\'%" + name + "%\'";
            String SQL = SEARCH.replaceAll("\\?", fixSearchString);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String nameEmployee = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                Position position = new Position(idPosition, namePosition);
                int idEducation = resultSet.getInt("Education_degree_id");
                String nameEducation = resultSet.getString("Education_degree_name");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);
                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("divison_name");
                Division division = new Division(idDivision, nameDivision);
                String nameUser = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                User user = new User(nameUser, password);
                Employee employee = new Employee(id, nameEmployee, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }
}
