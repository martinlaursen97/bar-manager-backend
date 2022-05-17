package com.company.barmanager.controller;

import com.company.barmanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/expenses")
public class ExpenseRESTController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseRESTController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
}
