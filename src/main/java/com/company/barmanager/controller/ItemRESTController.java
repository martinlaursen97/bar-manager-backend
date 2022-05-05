package com.company.barmanager.controller;

import com.company.barmanager.model.Item;
import com.company.barmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping
  public ResponseEntity<List<Item>> getItems(){
    return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/bar/{id}")
  public ResponseEntity<List<Item>> getItemsByBarId(@PathVariable Long id){
    return new ResponseEntity<>(itemService.getItemsByBarId(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item){
    item.setId(id);
    return new ResponseEntity<>(itemService.save(item), HttpStatus.OK);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Item> deleteItem(@PathVariable Long id){
    itemService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
