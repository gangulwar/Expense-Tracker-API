package com.gangulwar.expensetracker.controller;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.entity.Expense;
import com.gangulwar.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private TransactionService service;

    @PostMapping("/add/{username}")
    public ResponseEntity<ApiResponse<Expense>> add(@PathVariable String username, @RequestBody Expense expense) {
        return service.addExpense(username,expense);
    }
}
