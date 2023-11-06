package com.gangulwar.expensetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP") // Specifies the SQL data type as TIMESTAMP
    @Temporal(TemporalType.TIMESTAMP) // Specifies that both date and time should be stored
    private LocalDateTime dateTime;

    private double amount;
    private String description;
    private String category;
    private boolean isCredit;
}
