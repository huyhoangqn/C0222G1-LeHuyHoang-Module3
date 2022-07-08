package model.service.attach_service;

import model.bean.AttachService;
import model.repository.service.attaach_service.AttachServiceRepository;

import java.util.List;

public class AttachServiceImpl implements AttachServiceService {
    AttachServiceRepository attachServiceRepository = new AttachServiceRepository();


    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
