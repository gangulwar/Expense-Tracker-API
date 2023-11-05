package com.gangulwar.expensetracker.service;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.constants.Response;
import com.gangulwar.expensetracker.entity.User;
import com.gangulwar.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final TransactionService transactionService;

    @Autowired
    public UserService(UserRepository repository, TransactionService transactionService) {
        this.repository = repository;
        this.transactionService = transactionService;
    }

    public ResponseEntity<ApiResponse<User>> saveUser(User user) {
        if (!((repository.findAllByUsername(user.getUsername())).isEmpty())) {
//            System.out.println(((repository.findAllByUsername(user.getUsername())).isEmpty()));
            return Response.unsuccessfulUserCreationResource(user);
        } else {
            transactionService.createTable(user.getUsername());
            repository.save(user);
            return Response.successfulUserCreationResource(user);
//            repository.findAllByUsername(user.getUsername());
        }
    }

    public boolean authenticateUser(String username, String password) {
        return repository.authenticate(username, password) != null;
    }
}

