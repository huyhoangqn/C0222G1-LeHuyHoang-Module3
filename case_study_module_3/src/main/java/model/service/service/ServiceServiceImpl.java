package model.service.service;

import model.bean.Service;
import model.repository.service.ServiceRepository;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void add(Service service, int idTypeRent, int idTypeService) {
        serviceRepository.insertService(service, idTypeRent, idTypeService);
    }


//    @Override
//    public void add(Service service, int idTypeRent, int idTypeService) {
//        serviceRepository.insertService(service, idTypeRent, idTypeService);
//    }

//    @Override
//    public void update(int id, Service service) {
//        serviceRepository.update(id, service);
//    }
//
//    @Override
//    public Service remove(int id) {
//        serviceRepository.remove(id);
//        return null;
//    }
//
//    @Override
//    public List<Service> search(String name) {
//        return serviceRepository.search(name);
//    }
}
