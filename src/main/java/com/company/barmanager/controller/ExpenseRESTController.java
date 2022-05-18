package com.company.barmanager.controller;

import com.company.barmanager.model.Expense;
import com.company.barmanager.model.Item;
import com.company.barmanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/expenses")
public class ExpenseRESTController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseRESTController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping()
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        return new ResponseEntity<>(expenseService.save(expense), HttpStatus.CREATED);
    }
    @GetMapping("/bar/{id}")
    public ResponseEntity<List<Expense>> getExpensesByBarId(@PathVariable Long id){
        return new ResponseEntity<>(expenseService.getExpensesByBarId(id), HttpStatus.OK);
    }
}
