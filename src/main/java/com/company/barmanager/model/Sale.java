package com.company.barmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Sale {

  @Id
  @Column(name = "sale_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sale_date")
  private Date saleDate;

  @Column(name = "inco_total")
  private Double incoTotal;

  @Column(name = "tuborg_total")
  private Double tuborgTotal;
}
