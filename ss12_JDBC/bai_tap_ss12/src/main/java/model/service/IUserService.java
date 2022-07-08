package model.service;

import model.bean.User;

import java.util.List;

public interface IUserService {

    public List<User> selectAllUsers();

    public List<User> searchUser(String country);

    public List<User> searchAllBySort(String sort);
    public void delete(int id);
    public void addUser(String name, String email, String country);
    public User getUser(int id);
    public void update(int id, String name, String email, String country);
}
