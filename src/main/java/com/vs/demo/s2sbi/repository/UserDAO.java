package com.vs.demo.s2sbi.repository;

import com.vs.demo.s2sbi.domain.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void insertBatch();
    User addUser(User user);
}
