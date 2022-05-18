package com.company.barmanager.repository;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.model.SaleLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleLineItemRepository extends JpaRepository<SaleLineItem, Long> {
    List<SaleLineItem> getSaleLineItemsBySaleId(Long id);

    @Query("SELECT " +
        "    new com.company.barmanager.dto.ItemDTO(s.item, SUM(s.amountNo)) " +
        "FROM " +
        "    SaleLineItem s " +
        "INNER JOIN " +
        "    Item i ON s.item.id = i.id " +
        "WHERE " +
        "   i.bar.id = ?1 " +
        "GROUP BY " +
        "    s.item.id")
  List<ItemDTO> getItemDTOByBarId(Long id);
}
