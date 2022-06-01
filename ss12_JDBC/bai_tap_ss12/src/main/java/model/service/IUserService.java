package model.service;

import model.bean.User;

import java.util.List;

public interface IUserService {

    public List<User> selectAllUsers();

    public List<User> searchUser(String country);

    public List<User> searchAllBySort(String sort);
}
