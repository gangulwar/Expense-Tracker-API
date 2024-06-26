package com.gangulwar.expensetracker.constants;

import com.gangulwar.expensetracker.entity.Expense;
import com.gangulwar.expensetracker.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity<ApiResponse<User>> successfulUserCreationResource(User user) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("User created successfully");
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResponse<User>> unsuccessfulUserCreationResource(User user) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setStatus("failure");
        response.setMessage("User already exists");
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }


    public static ResponseEntity<AuthResponse> authenticationSuccessful(String token) {
//        ApiResponse<User> response = new ApiResponse<>("successful", "Authenticated Successfully", user);
        AuthResponse authResponse = new AuthResponse("successful", "Authenticated Successfully", token);
        return new ResponseEntity<>(authResponse, HttpStatus.ACCEPTED);
    }

    public static ResponseEntity<AuthResponse> authenticationUnsuccessful() {
//        ApiResponse<User> response = new ApiResponse<>();
//        response.setStatus("failure");
//        response.setMessage("Authenticated Unsuccessfully");
        AuthResponse authResponse = new AuthResponse("failure", "Unauthorized: Authentication unsuccessful.",null);
        return new ResponseEntity<>(authResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    public static ResponseEntity<ApiResponse<Expense>> expenseAddedSuccessful(Expense expense) {
        ApiResponse<Expense> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Expense Added Successfully");
        response.setData(expense);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResponse<Expense>> updateExpenseSuccessful(Expense expense) {
        ApiResponse<Expense> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Expense Updated Successfully");
        response.setData(expense);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse<Expense>> deleteExpenseSuccessful() {
        ApiResponse<Expense> response = new ApiResponse<>();
        response.setStatus("success");
        response.setMessage("Expense Deleted Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
