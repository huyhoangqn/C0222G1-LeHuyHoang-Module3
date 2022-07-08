package model.service.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void add(Customer customer);

    List<String> add(Customer customer, int type);

    void update(Customer customer, int type);

    boolean remove(int id);

    List<Customer> pagination(int page, int pageSize);

    long count();

    List<Customer> search(String name);

    List<Customer> getCustomerListHasContract();
}
