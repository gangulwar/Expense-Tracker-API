package com.gangulwar.expensetracker.service;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.constants.Response;
import com.gangulwar.expensetracker.entity.Expense;
import com.gangulwar.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ExpenseRepository expenseRepository;

    public void createTable(String tableName) {
//        String createTableSQL = "CREATE TABLE " + tableName + " (transaction_id INT AUTO_INCREMENT PRIMARY KEY, amount DECIMAL(10, 2) NOT NULL, isCredited BOOLEAN NOT NULL, category VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, transaction_date DATETIME NOT NULL)";
        String createTableSQL = "CREATE TABLE " + tableName + " LIKE expense_base";
        jdbcTemplate.execute(createTableSQL);
    }

    public ResponseEntity<ApiResponse<Expense>> addExpense(String username, Expense expense) {
        String insertExpenseSQL = "INSERT INTO " + username + " (amount, isCredited, category, description, transaction_date) VALUES (?, ?, ?, ?, ?)";
        System.out.println(expense.getDateTime());
        jdbcTemplate.update(insertExpenseSQL, expense.getAmount(), expense.isCredit(), expense.getCategory(), expense.getDescription(), expense.getDateTime());
        return Response.expenseAddedSuccessful(expense);
    }
}
