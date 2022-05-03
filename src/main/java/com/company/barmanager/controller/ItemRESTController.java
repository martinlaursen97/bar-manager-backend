package com.company.barmanager.controller;

import com.company.barmanager.model.Item;
import com.company.barmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/item")
public class ItemRESTController {

  private final ItemService itemService;

  @Autowired
  public ItemRESTController (ItemService itemService){
    this.itemService = itemService;
  }
  @PostMapping()
  public ResponseEntity<Item> createItem(@RequestBody Item item){
    return new ResponseEntity<>(itemService.save(item), HttpStatus.CREATED);
  }
}
