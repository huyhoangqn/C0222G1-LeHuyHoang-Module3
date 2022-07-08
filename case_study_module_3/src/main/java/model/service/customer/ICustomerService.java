package model.service.customer;

import model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomer();

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer getCustomer(int id);

    void updateCustomer(int maKhachHang, int maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND,
                        String soDienThoai, String email, String diaChi);

    List<String> add(Customer customer);
}
