package com.company.barmanager.repository;

import com.company.barmanager.model.SaleLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleLineItemRepository extends JpaRepository<SaleLineItem, Long> {
    List<SaleLineItem> getSaleLineItemsBySaleId(Long id);
}
