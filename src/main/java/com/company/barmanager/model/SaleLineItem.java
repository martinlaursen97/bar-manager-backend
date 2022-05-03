package com.company.barmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class SaleLineItem {

  @Id
  @Column(name = "sale_line_item_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "item_id")
  private Item item;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "sale_id")
  private Sale sale;

  @Column(name = "amount_no")
  private Integer amountNo;


}
