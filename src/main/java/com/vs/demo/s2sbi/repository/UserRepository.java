package com.vs.demo.s2sbi.repository;

import com.vs.demo.s2sbi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT max(u.id) FROM users u")
    Integer findMaxId();
}
