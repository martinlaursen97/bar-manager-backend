package com.company.barmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Bar {

  @Id
  @Column(name = "bar_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bar_name", unique = true)
  private String barName;

  @JsonBackReference(value = "items")
  @OneToMany(mappedBy = "bar", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<Item> items;

  @JsonBackReference(value = "sales")
  @OneToMany(mappedBy = "bar", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<Sale> sales;

  @JsonBackReference(value = "expenses")
  @OneToMany(mappedBy = "bar", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<Expense> expenses;



}
