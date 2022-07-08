package model.service.customer;

import model.bean.Customer;
import model.repository.Customer.CustomerRepo;
import model.repository.ICustomerRepo;
import model.service.validators.CustomerValidator;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepo customerRepo = new CustomerRepo();
    CustomerValidator customerValidator = new CustomerValidator();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepo.selectAllCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteCustomer(id);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepo.getCustomer(id);
    }

    @Override
    public void updateCustomer(int maKhachHang, int maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh,
                               String soCMND, String soDienThoai, String email, String diaChi) {
        customerRepo.updateCustomer(maKhachHang, maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);
    }

    @Override
    public List<String> add(Customer customer) {
        List<String> errors = customerValidator.validateCustomer(customer);
        if (errors.isEmpty()) {
            customerRepo.addCustomer(customer);
        }
        return errors;
    }


}
