package model.service.type_service;

import model.bean.TypeCustomer;
import model.bean.TypeService;
import model.repository.service.type_service.TypeServiceRepository;

import java.util.List;

public class TypeServiceServiceImpl implements TypeServiceService{
    TypeServiceRepository typeServiceRepository=new TypeServiceRepository();
    @Override
    public List<TypeService> getAll() {
        return typeServiceRepository.getAllTypeService();
    }
}
