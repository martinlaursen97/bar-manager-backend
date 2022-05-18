package com.company.barmanager.model;

import lombok.ToString;

public class ItemDTO {

  @ToString.Exclude
  private Item item;
  private Long sum;

  public ItemDTO(Item item, Long sum) {
    this.item = item;
    this.sum = sum;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Long getSum() {
    return sum;
  }

  public void setSum(Long sum) {
    this.sum = sum;
  }

  @Override
  public String toString() {
    return "ItemDTO{" +
            "item=" + item +
            ", sum=" + sum +
            '}';
  }
}
