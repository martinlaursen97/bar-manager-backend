package com.company.barmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Expense {
    @Id
    @Column(name = "expense_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "inco_total")
    private Double incoTotal;

    @Column(name = "tuborg_total")
    private Double tuborgTotal;
}
