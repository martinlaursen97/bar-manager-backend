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


  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "bar_id")
  private Bar bar;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "type_id")
  private Type type;

  @JsonBackReference(value = "saleLineItems")
  @OneToMany(mappedBy = "item", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<SaleLineItem> saleLineItems;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "amount_no")
  private Integer amountNo;

  @Column(name = "active")
  private Boolean isActive;

}
