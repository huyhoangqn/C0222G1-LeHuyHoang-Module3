package model.service.type_customer;

import model.bean.TypeCustomer;
import model.repository.customer.type_customer.TypeCustomerRepository;

import java.util.List;

public class TypeCustomerServiceImpl implements TypeCustomerService{
    TypeCustomerRepository typeCustomerRepository =new TypeCustomerRepository();
    @Override
    public List<TypeCustomer> getAll() {
        return typeCustomerRepository.getAllTypeCustomer() ;
    }
}
