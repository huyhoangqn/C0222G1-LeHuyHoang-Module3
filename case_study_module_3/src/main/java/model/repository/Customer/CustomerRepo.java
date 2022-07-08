package model.repository.Customer;

import model.bean.Customer;
import model.repository.DatabaseRepository;
import model.repository.ICustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM khach_hang";
    private static final String ADD_CUSTOMER = "INSERT INTO khach_hang (`ma_loai_khach`, `ho_ten`, `ngay_sinh`," +
            " `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from khach_hang where ma_khach_hang = ?";
    private static final String UPDATE_CUSTOMER_BY_ID = "UPDATE `khach_hang` SET `ma_loai_khach` = ?, `ho_ten` = ?, " +
            "`ngay_sinh` = ?, `gioi_tinh` = ?, `so_cmnd` = ?, `so_dien_thoai` = ?, `email` = ?, `dia_chi` = ? " +
            "WHERE (`ma_khach_hang` = ?);";
    private static final String SELECT_CUSTOMER = "select * from khach_hang where ma_khach_hang =?";
    DatabaseRepository data = new DatabaseRepository();

    public List<Customer> selectAllCustomer() {
        Connection connection = data.connectDataBase();
        List<Customer> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maKhachHang = resultSet.getInt(1);
                int maLoaiKhach = resultSet.getInt(2);
                String hoTen = resultSet.getString(3);
                String ngaySinh = resultSet.getString(4);
                Integer gioiTinh = resultSet.getInt(5);
                String soCMND = resultSet.getString(6);
                String soDienThoai = resultSet.getString(7);
                String email = resultSet.getString(8);
                String diaChi = resultSet.getString(9);
                Customer customer = new Customer(maKhachHang, maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);
                userList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }


//    @Override
//    public void addCustomer(int maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND,
//                            String soDienThoai, String email, String diaChi) {
//        Connection connection = data.connectDataBase();
//        try {
//            PreparedStatement ps = connection.prepareStatement(ADD_CUSTOMER);
//            ps.setInt(1, maLoaiKhach);
//            ps.setString(2, hoTen);
//            ps.setString(3, ngaySinh);
//            ps.setInt(4, gioiTinh);
//            ps.setString(5, soCMND);
//            ps.setString(6, soDienThoai);
//            ps.setString(7, email);
//            ps.setString(8, diaChi);
//            ps.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    @Override
    public void addCustomer(Customer customer) {
        Connection connection = data.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setInt(1, customer.getMaLoaiKhach());
            preparedStatement.setString(2, customer.getHoTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            preparedStatement.setInt(4, customer.getGioiTinh());
            preparedStatement.setString(5, customer.getSoCMND());
            preparedStatement.setString(6, customer.getSoDienThoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDiaChi());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void deleteCustomer(int id) {
        Connection connection = data.connectDataBase();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(int maKhachHang, int maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND,
                               String soDienThoai, String email, String diaChi) {
        Connection connection = data.connectDataBase();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            ps.setInt(1, maLoaiKhach);
            ps.setString(2, hoTen);
            ps.setString(3, ngaySinh);
            ps.setInt(4, gioiTinh);
            ps.setString(5, soCMND);
            ps.setString(6, soDienThoai);
            ps.setString(7, email);
            ps.setString(8, diaChi);
            ps.setInt(9, maKhachHang);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(int id) {
        Connection connection = data.connectDataBase();
        Customer customer = new Customer();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int maKhachHang = resultSet.getInt(1);
                int maLoaiKhach = resultSet.getInt(2);
                String hoTen = resultSet.getString(3);
                String ngaySinh = resultSet.getString(4);
                Integer gioiTinh = resultSet.getInt(5);
                String soCMND = resultSet.getString(6);
                String soDienThoai = resultSet.getString(7);
                String email = resultSet.getString(8);
                String diaChi = resultSet.getString(9);
                customer = new Customer(maKhachHang, maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }


}

