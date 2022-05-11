package com.company.barmanager.controller;

import com.company.barmanager.model.Item;
import com.company.barmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/items")
public class ItemRESTController {

  private final ItemService itemService;

  @Autowired
  public ItemRESTController (ItemService itemService){
    this.itemService = itemService;
  }
  @PostMapping()
  public ResponseEntity<Item> createItem(@RequestBody Item item){
    System.out.println(item);
    return new ResponseEntity<>(itemService.save(item), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Item>> getItems(@RequestParam Optional<String> keyword, @RequestParam Optional<Long> barId, @RequestParam Optional<Long> typeId){
    if (keyword.isPresent()&& barId.isPresent() && !typeId.isPresent()){
      return new ResponseEntity<>(itemService.getItemsByItemNameAndBarId(keyword.get(), barId.get()), HttpStatus.OK);
    }
    if (!keyword.isPresent()&& barId.isPresent() && typeId.isPresent()){
      return new ResponseEntity<>(itemService.getItemsByBarIdAndTypeId(barId.get(), typeId.get()), HttpStatus.OK);
    }
    if (keyword.isPresent()&& barId.isPresent()&& typeId.isPresent()) {
      return new ResponseEntity<>(itemService.getItemsByItemNameAndBarIdAndTypeId(keyword.get(), barId.get(), typeId.get()), HttpStatus.OK);
    }

    return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/bar/{id}")
  public ResponseEntity<List<Item>> getItemsByBarId(@PathVariable Long id){
    return new ResponseEntity<>(itemService.getItemsByBarId(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Item> updateItem(@RequestBody Item item){
    System.out.println(item);
    return new ResponseEntity<>(itemService.save(item), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Item> deleteItem(@PathVariable Long id){
    itemService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
