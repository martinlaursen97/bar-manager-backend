package com.company.barmanager.service;

import com.company.barmanager.model.Expense;
import com.company.barmanager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

  public Expense save(Expense expense) {
      return expenseRepository.save(expense);
  }

  public List<Expense> getExpensesByBarId(Long id) {
      return expenseRepository.getExpensesByBarId(id);
  }

    public List<Expense> findByDateAndBarId(Long id, String date) {
        return expenseRepository.findByDateAndBarId(id, date);
    }

    public List<Expense> findAllByBarId(Long id) {
        return expenseRepository.findAllByBarId(id);
    }
}
