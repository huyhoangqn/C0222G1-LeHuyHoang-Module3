package model.service.service;

import model.bean.Service;
import model.repository.contract.ContractRepository;
import model.repository.service.ServiceRepository;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

        @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void add(Service service) {
        serviceRepository.insertService(service);
    }

    @Override
    public void add(Service service, int idTypeRent, int idTypeService) {
        serviceRepository.insertService(service, idTypeRent, idTypeService);
    }

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
