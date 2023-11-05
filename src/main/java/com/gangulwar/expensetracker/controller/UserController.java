package com.gangulwar.expensetracker.controller;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.entity.User;
import com.gangulwar.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/newUser")
    public ResponseEntity<ApiResponse<User>> newUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/auth")
    public boolean checkUser(@RequestParam String username, @RequestParam String password) {
        return service.authenticateUser(username, password);
    }
}
