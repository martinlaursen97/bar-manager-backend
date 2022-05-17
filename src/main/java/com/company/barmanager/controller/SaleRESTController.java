package com.company.barmanager.controller;

import com.company.barmanager.model.Item;
import com.company.barmanager.model.Sale;
import com.company.barmanager.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
  public ResponseEntity<List<Sale>> getSales(){
    return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/bar/{id}")
  public ResponseEntity<List<Sale>> getSalesByBarId(@PathVariable Long id){
    return new ResponseEntity<>(saleService.getSalesByBarId(id), HttpStatus.OK);
  }
}
