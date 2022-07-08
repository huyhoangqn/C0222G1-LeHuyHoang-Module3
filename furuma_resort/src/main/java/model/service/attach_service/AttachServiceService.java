package model.service.attach_service;

import model.bean.AttachService;

import java.util.List;


public interface AttachServiceService {
    AttachService findById(int id);

    List<AttachService> findAll();
}
