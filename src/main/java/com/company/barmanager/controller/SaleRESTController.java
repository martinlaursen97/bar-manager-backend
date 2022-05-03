package com.company.barmanager.controller;

import com.company.barmanager.model.Sale;
import com.company.barmanager.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/sale")
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
}
