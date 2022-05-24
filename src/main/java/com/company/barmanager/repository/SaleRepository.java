package com.company.barmanager.repository;

import com.company.barmanager.dto.TypeDTO;
import com.company.barmanager.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
   List<Sale> getSalesByBarId(Long id);

   @Query("SELECT s FROM Sale s WHERE s.saleDate >= ?2 AND s.saleDate <= ?3 AND s.bar.id = ?1 ORDER BY s.saleDate")
   List<Sale> getSalesByDateAndBarId(Long id, LocalDate date1, LocalDate date2);


   @Query("SELECT s FROM Sale s WHERE s.bar.id = ?1 AND s.saleDate = ?2")
   List<Sale> findBySaleDateAndBarId(Long id, LocalDate date);



   @Query("SELECT " +
           "   new com.company.barmanager.dto.TypeDTO(t, SUM(sli.amountNo)) " +
           "FROM " +
           "   Sale s " +
           "JOIN SaleLineItem sli " +
           "   ON s.id = sli.sale.id " +
           "JOIN Item i " +
           "   ON sli.item.id = i.id " +
           "JOIN Type t " +
           "   ON i.type.id = t.id " +
           "WHERE i.bar.id = ?1 " +
           "AND s.saleDate >= ?2 " +
           "AND s.saleDate <= ?3 " +
           "GROUP BY " +
           "   t.id")
    List<TypeDTO> getTypeDTOByBarId(Long id, LocalDate date1, LocalDate date2);
}
