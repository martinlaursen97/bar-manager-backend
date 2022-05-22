package com.company.barmanager.repository;

import com.company.barmanager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  List<Expense> getExpensesByBarId(Long id);

  @Query("SELECT e FROM Expense e WHERE e.bar.id = ?1 AND e.expenseDateStr = ?2")
  List<Expense> findByDateAndBarId(Long id, String date);

  @Query("SELECT e FROM Expense e WHERE e.bar.id = ?1")
  List<Expense> findAllByBarId(Long id);
}
