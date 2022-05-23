package com.company.barmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Sale {

  @Id
  @Column(name = "sale_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "bar_id")
  private Bar bar;

  @Column(name = "sale_date")
  private LocalDate saleDate;

  @Column(name = "revenue")
  private Double revenue;

  @JsonBackReference(value = "saleLineItem")
  @OneToMany(mappedBy = "sale", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<SaleLineItem> saleLineItems;
}
