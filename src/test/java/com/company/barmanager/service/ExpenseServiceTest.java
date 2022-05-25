package com.company.barmanager.service;

import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.model.Expense;
import com.company.barmanager.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ExpenseService.class)
class ExpenseServiceTest {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    BarService barService;

    @Test
    void save() {
        Expense expense = new Expense();
        Expense saved = expenseService.save(expense);
        Assertions.assertNotNull(saved);
    }

    @Test
        void getExpensesByBarId() throws BarNameTakenException {
        Bar bar = new Bar();
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense();
        expenses.add(expense);


        bar.setExpenses(expenses);

        Bar savedBar = barService.save(bar);

        expense.setBar(savedBar);
        expenseService.save(expense);

        Assertions.assertNotEquals(0, expenseService.getExpensesByBarId(savedBar.getId()).size());



    }

    @Test
    void findByDateAndBarId() throws BarNameTakenException {
        Bar bar = new Bar();
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense();
        expense.setExpenseDateStr("W20-2022");
        bar.setExpenses(expenses);
        Bar savedBar = barService.save(bar);
        expense.setBar(savedBar);

        Expense savedExpense = expenseService.save(expense);

        List<Expense> found = expenseService.findByDateAndBarId(savedBar.getId(), savedExpense.getExpenseDateStr());

        Assertions.assertNotEquals(0, found.size());
    }

    @Test
    void findAllByBarId() throws BarNameTakenException {
        Bar bar = new Bar();

        List<Expense> expenses = new ArrayList<>();
        Expense e1 = new Expense();

        bar.setExpenses(expenses);

        Bar savedBar = barService.save(bar);

        e1.setBar(savedBar);

        expenseService.save(e1);

        List<Expense> found = expenseService.findAllByBarId(savedBar.getId());

        Assertions.assertNotEquals(0, found.size());
    }
}