package com.company.barmanager.service;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.model.SaleLineItem;
import com.company.barmanager.repository.SaleLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<ItemDTO> getItemDTOByBarId(Long id, LocalDate date1, LocalDate date2) {
        return saleLineItemRepository.getItemDTOByBarId(id, date1, date2);
    }
}

