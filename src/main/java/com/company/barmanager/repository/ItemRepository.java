package com.company.barmanager.repository;

import com.company.barmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItemsByBarId(Long id);

  List<Item> getItemsByItemNameAndBarId(String keyword, Long barId);
}
