package model.service.service;

import model.bean.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    Service findById(int id);

    void add(Service service);

    void add(Service service, int idTypeRent, int idTypeService);
//
//    void update(int id, Service service);
//
//    Service remove(int id);
//
//    List<Service> search(String name);S
}
