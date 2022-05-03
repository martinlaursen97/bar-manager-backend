package com.company.barmanager.controller;

import com.company.barmanager.service.SaleLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/sale-line-item")
public class SaleLineItemRESTController {

    private SaleLineItemService saleLineItemService;

    @Autowired
    public SaleLineItemRESTController(SaleLineItemService saleLineItemService){
        this.saleLineItemService = saleLineItemService;
    }


}
