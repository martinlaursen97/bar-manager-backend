package com.company.barmanager.service;

import com.company.barmanager.model.ItemDTO;
import com.company.barmanager.model.Sale;
import com.company.barmanager.model.SaleLineItem;
import com.company.barmanager.repository.SaleLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleLineItemService {
    private final SaleLineItemRepository saleLineItemRepository;

    @Autowired
    public SaleLineItemService(SaleLineItemRepository saleLineItemRepository){
        this.saleLineItemRepository = saleLineItemRepository;
    }


    public SaleLineItem save(SaleLineItem saleLineItem){
        return saleLineItemRepository.save(saleLineItem);
    }

    public List<SaleLineItem> getSaleLineItemsBySaleId(Long id) {
        return saleLineItemRepository.getSaleLineItemsBySaleId(id);
    }

    public List<ItemDTO> test() {
        return saleLineItemRepository.test();
    }
}

