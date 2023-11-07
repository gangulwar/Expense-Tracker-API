package com.gangulwar.expensetracker.controller;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.entity.Expense;
import com.gangulwar.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private TransactionService service;

    @PostMapping("/add/{username}")
    public ResponseEntity<ApiResponse<Expense>> add(@PathVariable String username, @RequestBody Expense expense) {
        return service.addExpense(username, expense);
    }

    @GetMapping("/get/all/{username}")
    public List<Expense> getAllExpenses(@PathVariable String username) {
        return service.getAllExpenses(username);
    }

    @PutMapping("/update/{username}/{id}")
    public ResponseEntity<ApiResponse<Expense>> updateExpense(@RequestBody Expense expense, @PathVariable String username, @PathVariable Long id) {
        return service.update(expense, username, id);
    }

    @DeleteMapping("/delete/{username}/{id}")
    public ResponseEntity<ApiResponse<Expense>> deleteExpense(@PathVariable String username, @PathVariable Long id) {
        return service.delete(username, id);
    }

}