package model.service.customer;

import model.bean.Customer;
import model.repository.contract.ContractRepository;
import model.repository.customer.CustomerRepository;
import model.service.contract.ContractServiceImpl;
import model.service.validators.CustomerValidator;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();
    CustomerValidator customerValidator = new CustomerValidator();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public List<String> add(Customer customer, int type) {
        List<String> errors = customerValidator.validateCustomer(customer);
        if (errors.isEmpty()) {
           customerRepository.insertCustomer(customer, type);
        }
        return errors;
    }


    @Override
    public void update(Customer customer, int type) {
        customerRepository.update(customer, type);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }

    @Override
    public List<Customer> pagination(int page, int pageSize) {
        return customerRepository.getListByPagination(page, pageSize);
    }

    @Override
    public long count() {
        return customerRepository.countAll();
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.search(name);
    }

    @Override
    public List<Customer> getCustomerListHasContract() {
        List<Customer> customers = customerRepository.getCustomerListHasContract();

        return customers;
    }


//
//    @Override
//    public Customer remove(int id) {
//        customerRepository.remove(id);
//        return null;
//    }
//
//    @Override
//    public List<Customer> search(String name) {
//        return customerRepository.search(name);
//    }
}
