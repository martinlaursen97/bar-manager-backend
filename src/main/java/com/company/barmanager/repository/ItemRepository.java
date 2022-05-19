package com.company.barmanager.repository;

import com.company.barmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItemsByBarId(Long id);

  List<Item> getItemsByItemNameAndBarIdAndTypeId(String keyword, Long barId, Long typeId);

  List<Item> getItemsByItemNameAndBarId(String keyword, Long barId);

  List<Item> getItemsByBarIdAndTypeId(Long barId, Long typeId);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("UPDATE Item i SET i.isActive = " +
      "CASE i.isActive " +
      "WHEN TRUE THEN FALSE " +
      "WHEN FALSE THEN TRUE " +
      "ELSE i.isActive END " +
      "WHERE i.id = ?1")
  void setActiveById(Long id);

  @Query("SELECT i FROM Item i WHERE i.bar.id = ?1 AND i.isActive = TRUE")
  List<Item> getActiveItemsByBarId(Long id);
}
