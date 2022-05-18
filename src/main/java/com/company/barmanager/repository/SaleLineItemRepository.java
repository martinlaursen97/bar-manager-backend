package com.company.barmanager.repository;

import com.company.barmanager.model.ItemDTO;
import com.company.barmanager.model.SaleLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleLineItemRepository extends JpaRepository<SaleLineItem, Long> {
    List<SaleLineItem> getSaleLineItemsBySaleId(Long id);

    //@Query("select new com.company.barmanager.model.ItemDTO(s.item.id, sum(s.amountNo)) from SaleLineItem as s group by s.amountNo")
    @Query("SELECT " +
        "    new com.company.barmanager.model.ItemDTO (s.item, SUM(s.amountNo)) " +
        "FROM " +
        "    SaleLineItem s " +
        "GROUP BY " +
        "    s.amountNo")
  List<ItemDTO> test();



}
