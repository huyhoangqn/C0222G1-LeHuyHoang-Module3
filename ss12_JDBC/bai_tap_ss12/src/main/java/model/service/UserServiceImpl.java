package model.service;

import model.bean.User;
import model.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository = new UserRepository();


    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUser();
    }

    @Override
    public List<User> searchUser(String country) {
        return userRepository.searchUserByCountry(country);
    }

    @Override
    public List<User> searchAllBySort(String sort) {
        return userRepository.sort(sort);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public void addUser(String name, String email, String country) {
        userRepository.addUser(name, email, country);
    }

    @Override
    public User getUser(int id) {
        return userRepository.returnUser(id);
    }

    @Override
    public void update(int id, String name, String email, String country) {
        userRepository.update(id, name, email, country);
    }


}
