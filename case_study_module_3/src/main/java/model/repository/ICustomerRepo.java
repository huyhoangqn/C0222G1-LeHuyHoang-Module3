package model.repository;

import model.bean.Customer;

import java.util.List;

public interface ICustomerRepo {
    public List<Customer> selectAllCustomer();

    public void addCustomer(Customer customer);

    public void deleteCustomer(int id);


    public Customer getCustomer(int id);

    public void updateCustomer(int maKhachHang, int maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND,
                               String soDienThoai, String email, String diaChi);
}
