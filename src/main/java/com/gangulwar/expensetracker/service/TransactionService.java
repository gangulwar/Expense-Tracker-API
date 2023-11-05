package com.gangulwar.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable(String tableName) {
        String createTableSQL = "CREATE TABLE " + tableName + " (transaction_id INT AUTO_INCREMENT PRIMARY KEY, amount DECIMAL(10, 2) NOT NULL, isCredited BOOLEAN NOT NULL, category VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, transaction_date DATETIME NOT NULL)";
        jdbcTemplate.execute(createTableSQL);
    }

}
