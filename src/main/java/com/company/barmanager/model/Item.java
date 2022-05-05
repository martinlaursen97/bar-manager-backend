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
public class Item {

  @Id
  @Column(name = "item_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "bar_id")
  private Bar bar;

  //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  //private List<SaleLineItem> saleLineItem;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "amount_no")
  private Integer amountNo;

  private Double price;


}
