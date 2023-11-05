package com.gangulwar.expensetracker.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T data;
}