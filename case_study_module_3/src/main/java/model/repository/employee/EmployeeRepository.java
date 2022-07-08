package model.repository.employee;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String GET_ALL = "select * from nhan_vien left join vi_tri on nhan_vien.ma_vi_tri = " +
            "vi_tri.ma_vi_tri left join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do left join bo_phan" +
            " on bo_phan.ma_bo_phan=nhan_vien.ma_bo_phan;";
    private static final String INSERT_INTO = "INSERT INTO `nhan_vien` (`ho_ten`, `ngay_sinh`," +
            " `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?);\n";

    private static final String UPDATE = "UPDATE `nhan_vien` SET `ho_ten` = ?," +
            " `ngay_sinh` = ?, `so_cmnd` = ?, `luong` = ?, `so_dien_thoai` = ?, " +
            "`email` = ?, `dia_chi` = ?, `ma_vi_tri` = ?, `ma_trinh_do` = ?," +
            " `ma_bo_phan` = ? WHERE (`ma_nhan_vien` = ?);\n";
    private static final String DELETE = "DELETE FROM nhan_vien WHERE ma_nhan_vien = ? ";
    private static final String FIND_BY_ID = "select * from nhan_vien where ma_nhan_vien=?;";
    private static final String SEARCH = "select * from nhan_vien where ho_ten like ? and ma_vi_tri LIKE? and ma_trinh_do LIKE? ;";
    private static final String POSITION = "select ten_vi_tri from vi_tri where ma_vi_tri =?;";
    private static final String EDUCATION = "select ten_trinh_do from trinh_do where ma_trinh_do = ?;";
    private static final String DIVISION = "select ten_bo_phan from bo_phan where ma_bo_phan=?;";


    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<Employee> findAll() {
        connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");

                int idPosition = resultSet.getInt("ma_vi_tri");
                String namePosition = resultSet.getString("ten_vi_tri");
                Position position = new Position(idPosition, namePosition);

                int idEducation = resultSet.getInt("ma_trinh_do");
                String nameEducation = resultSet.getString("ten_trinh_do");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);

                int idDivision = resultSet.getInt("ma_bo_phan");
                String nameDivision = resultSet.getString("ten_bo_phan");
                Division division = new Division(idDivision, nameDivision);

                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }


    public void insertEmployee(Employee employee) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducation());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void update(Employee employee) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducation());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.setInt(11, employee.getId());
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

    public Employee findById(int id) {
        connection = databaseRepository.connectDataBase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getByte(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String idCard = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);
                int idPosition = resultSet.getInt(9);
                int idEducation = resultSet.getInt(10);
                int idDivision = resultSet.getInt(11);
                employee = new Employee(idEmployee, name, birthday, idCard, salary, phone, email, address, idPosition, idEducation, idDivision);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public String findPositon(int id) {
        connection = databaseRepository.connectDataBase();
        String position = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(POSITION);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                position = resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return position;
    }

    public String findEducation(int id) {
        connection = databaseRepository.connectDataBase();
        String education = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDUCATION);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                education = resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return education;
    }

    public String findDivison(int id) {
        connection = databaseRepository.connectDataBase();
        String division = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DIVISION);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                division = resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return division;
    }


    public List<Employee> Search(String name1, int idPositon, int idEducation) {
        connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + name1 + "%");
            preparedStatement.setString(2, "%" + idPositon + "%");
            preparedStatement.setString(3, "%" + idEducation + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");

                String position = findPositon(resultSet.getInt(9));
                String education = findEducation(resultSet.getInt(10));
                String division = findDivison(resultSet.getInt(11));

                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }
}
