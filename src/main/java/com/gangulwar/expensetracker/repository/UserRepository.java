package com.gangulwar.expensetracker.repository;

import com.gangulwar.expensetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User authenticate(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findAllByUsername(@Param("username") String username);
}
