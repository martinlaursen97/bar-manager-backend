package com.company.barmanager.service;

import com.company.barmanager.model.Sale;
import com.company.barmanager.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
  private final SaleRepository saleRepository;

  @Autowired
  public SaleService(SaleRepository saleRepository){
    this.saleRepository = saleRepository;
  }


  public Sale save(Sale sale){
    return saleRepository.save(sale);
  }

  public List<Sale> findAll() {
    return saleRepository.findAll();
  }

  public List<Sale> getSalesByBarId(Long id) {
    return saleRepository.getSalesByBarId(id);
  }

  public List<Sale> getSalesByDateAndBarId(Long id, LocalDate date1, LocalDate date2) {
    return saleRepository.getSalesByDateAndBarId(id, date1, date2);
  }
}
