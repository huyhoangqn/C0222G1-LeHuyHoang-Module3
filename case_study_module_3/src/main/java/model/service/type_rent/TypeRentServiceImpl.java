package model.service.type_rent;

import model.bean.TypeRent;
import model.repository.service.type_rent.TypeRentRepository;

import java.util.List;

public class TypeRentServiceImpl implements TypeRentService {
    TypeRentRepository typeRentRepository = new TypeRentRepository();

    @Override
    public List<TypeRent> getAll() {
        return typeRentRepository.getAllTypeRent();
    }
}
