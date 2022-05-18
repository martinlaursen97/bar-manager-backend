package com.company.barmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

@Entity
@Getter
@Setter
@ToString
public class Expense {
    @Id
    @Column(name = "expense_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bar_id")
    private Bar bar;

    @Column(name = "expense_date")
    private String expenseDateStr;

    @Column(name = "inco_total")
    private Double incoTotal;

    @Column(name = "tuborg_total")
    private Double tuborgTotal;

    @Column(name = "total_expense")
    private Double totalExpense;
}
