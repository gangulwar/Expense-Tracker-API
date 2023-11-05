package com.gangulwar.expensetracker.constants;

import com.gangulwar.expensetracker.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity<ApiResponse<User>> successfulUserCreationResource(User user){
        ApiResponse<User> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("User created successfully");
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResponse<User>> unsuccessfulUserCreationResource(User user){
        ApiResponse<User> response = new ApiResponse<>();
        response.setStatus("failure");
        response.setMessage("User already exists");
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
