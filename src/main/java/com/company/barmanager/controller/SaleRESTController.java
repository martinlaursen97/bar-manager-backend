package com.company.barmanager.controller;

import com.company.barmanager.model.Item;
import com.company.barmanager.model.Sale;
import com.company.barmanager.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/sales")
public class SaleRESTController {

  private final SaleService saleService;

  @Autowired
  public SaleRESTController(SaleService saleService){
    this.saleService = saleService;
  }

  @PostMapping()
  public ResponseEntity<Sale> createSale(@RequestBody Sale sale){
    return new ResponseEntity<>(saleService.save(sale), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<Sale>> getSales(@RequestParam(name = "barId") Long id, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Optional<LocalDate> date) {
    if (date.isPresent()) {
      return new ResponseEntity<>(saleService.findBySaleDateAndBarId(id, date.get()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
    }
  }

  @GetMapping("/bar/{id}")
  public ResponseEntity<List<Sale>> getSalesByBarId(@PathVariable Long id){
    return new ResponseEntity<>(saleService.getSalesByBarId(id), HttpStatus.OK);
  }

  @GetMapping("/statistics/{id}/{date1}/{date2}")
  public ResponseEntity<List<Sale>> getSalesByDateAndById(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
    return new ResponseEntity<>(saleService.getSalesByDateAndBarId(id, date1, date2), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Sale> deleteSaleById(@PathVariable Long id){
    saleService.deleteSaleById(id);
    System.out.println(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
