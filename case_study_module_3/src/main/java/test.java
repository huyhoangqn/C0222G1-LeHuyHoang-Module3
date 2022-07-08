import model.bean.Customer;
import model.repository.Customer.CustomerRepo;

import java.util.List;

public class test {
    public static void main(String[] args) {
        CustomerRepo customerRepo = new CustomerRepo();
        List<Customer> customerList = customerRepo.selectAllCustomer();
        System.out.println(customerList);
    }
}
