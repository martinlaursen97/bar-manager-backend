package com.company.barmanager.repository;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.model.SaleLineItem;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleLineItemRepository extends JpaRepository<SaleLineItem, Long> {
    List<SaleLineItem> getSaleLineItemsBySaleId(Long id);

    @Query("SELECT " +
        "    new com.company.barmanager.dto.ItemDTO(s.item, SUM(s.amountNo)) " +
        "FROM " +
        "    SaleLineItem s " +
        "INNER JOIN " +
        "    Sale i ON s.sale.id = i.id " +
        "WHERE " +
        "   i.bar.id = ?1 " +
        "AND i.saleDate >= ?2 " +
        "AND i.saleDate <= ?3 " +
        "GROUP BY " +
        "    s.item.id")
  List<ItemDTO> getItemDTOByBarId(Long id, LocalDate date1, LocalDate date2);
}
