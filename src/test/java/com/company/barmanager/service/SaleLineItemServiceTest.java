package com.company.barmanager.service;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.model.Item;
import com.company.barmanager.model.Sale;
import com.company.barmanager.model.SaleLineItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SaleLineItemService.class)
class SaleLineItemServiceTest {

  @Autowired
  SaleLineItemService saleLineItemService;

  @Autowired
  SaleService saleService;

  @Autowired
  BarService barService;

  @Autowired
  ItemService itemService;

  @Test
  void save() {
    SaleLineItem saleLineItem = new SaleLineItem();
    SaleLineItem saved = saleLineItemService.save(saleLineItem);
    Assertions.assertNotNull(saved);
  }

  @Test
  void getSaleLineItemsBySaleId() {
    Sale sale = new Sale();
    List<SaleLineItem> saleLineItemList = new ArrayList<>();
    SaleLineItem saleLineItem = new SaleLineItem();
    saleLineItemList.add(saleLineItem);

    sale.setSaleLineItems(saleLineItemList);

    Sale savedSale = saleService.save(sale);

    saleLineItem.setSale(savedSale);

    saleLineItemService.save(saleLineItem);

    assertEquals(1, saleLineItemService.getSaleLineItemsBySaleId(savedSale.getId()).size());
  }

  @Test
  void getItemDTOByBarId() throws BarNameTakenException {
    Sale sale = new Sale();
    SaleLineItem saleLineItem = new SaleLineItem();
    Item item = new Item();
    Bar bar = new Bar();

    sale.setSaleDate(LocalDate.now());
    saleLineItem.setItem(item);
    item.setBar(bar);

    List<SaleLineItem> saleLineItemList = new ArrayList<>();
    saleLineItemList.add(saleLineItem);

    sale.setSaleLineItems(saleLineItemList);

    Bar savedBar = barService.save(bar);
    itemService.save(item);
    saleService.save(sale);
    saleLineItemService.save(saleLineItem);

    List<ItemDTO> itemDTOS = saleLineItemService.getItemDTOByBarId(savedBar.getId(), LocalDate.now(), LocalDate.now());

    assertNotNull(itemDTOS);













  }
}