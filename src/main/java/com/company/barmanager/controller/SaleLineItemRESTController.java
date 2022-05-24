package com.company.barmanager.controller;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.model.SaleLineItem;
import com.company.barmanager.service.SaleLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/sale-line-items")
public class SaleLineItemRESTController {

    private final SaleLineItemService saleLineItemService;

    @Autowired
    public SaleLineItemRESTController(SaleLineItemService saleLineItemService){
        this.saleLineItemService = saleLineItemService;
    }

    @PostMapping
    public ResponseEntity<SaleLineItem> createSaleLineItem(@RequestBody SaleLineItem saleLineItem) {
        return new ResponseEntity<>(saleLineItemService.save(saleLineItem), HttpStatus.CREATED);
    }

    @GetMapping("/sale/{id}")
    public ResponseEntity<List<SaleLineItem>> getSaleLineItemsBySaleId(@PathVariable Long id) {
        return new ResponseEntity<>(saleLineItemService.getSaleLineItemsBySaleId(id), HttpStatus.OK);
    }

    @GetMapping ("/statistics/bar/{id}/{date1}/{date2}")
    public ResponseEntity<List<ItemDTO>> getItemDTOByBarId(@PathVariable Long id,
                                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
                                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        List<ItemDTO> itemDTOS = saleLineItemService.getItemDTOByBarId(id, date1, date2);
        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }


}
