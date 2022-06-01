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

}
