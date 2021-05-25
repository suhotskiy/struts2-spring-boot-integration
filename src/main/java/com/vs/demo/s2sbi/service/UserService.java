package com.vs.demo.s2sbi.service;

import com.vs.demo.s2sbi.domain.User;
import com.vs.demo.s2sbi.repository.UserDAO;
import com.vs.demo.s2sbi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    private final UserRepository userRepository;
    private final UserDAO userDAO;

    public UserService(UserRepository userRepository, UserDAO userDAO) {
        this.userRepository = userRepository;
        this.userDAO = userDAO;
    }

    public void populateUsers() {
        userDAO.insertBatch();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        user.setId(userRepository.findMaxId() + 1);
        return userRepository.save(user);
    }
}
