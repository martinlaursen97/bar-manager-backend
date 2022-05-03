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
public class Item {

  @Id
  @Column(name = "item_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "bar_id")
  private Bar bar;

  @OneToMany(cascade = CascadeType.MERGE)
  @JoinColumn(name = "item_id")
  private List<SaleLineItem> saleLineItem;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "amount_no")
  private Integer amountNo;

  private Double price;


}
