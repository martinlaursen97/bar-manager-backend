package com.company.barmanager.repository;

import com.company.barmanager.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
   List<Sale> getSalesByBarId(Long id);

   @Query("SELECT s FROM Sale s WHERE s.saleDate >= ?2 AND s.saleDate < ?3 AND s.bar.id = ?1")
  List<Sale> getSalesByDateAndBarId(Long id, LocalDate date1, LocalDate date2);
}
