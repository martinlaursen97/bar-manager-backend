package com.company.barmanager.service;


import com.company.barmanager.model.Item;
import com.company.barmanager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
  private final ItemRepository itemRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item save(Item item) {
    return itemRepository.save(item);
  }

  public List<Item> findAll() {
    return itemRepository.findAll();
  }

  public void deleteById(Long id) {
    itemRepository.deleteById(id);
  }

  public List<Item> getItemsByBarId(Long id) {
    return itemRepository.getItemsByBarId(id);
  }

  public List<Item> getItemsByItemNameAndBarIdAndTypeId(String keyword, Long barId, Long typeId) {
    return itemRepository.getItemsByItemNameAndBarIdAndTypeId(keyword, barId, typeId);
  }

  public List<Item> getItemsByItemNameAndBarId(String keyword, Long barId) {
    return itemRepository.getItemsByItemNameAndBarId(keyword, barId);
  }

  public List<Item> getItemsByBarIdAndTypeId(Long barId, Long typeId) {
    return itemRepository.getItemsByBarIdAndTypeId(barId, typeId);
  }


  public void setActiveById(Long id) {
    itemRepository.setActiveById(id);
  }

  public List<Item> getActiveItemsByBarId(Long id) {
    return itemRepository.getActiveItemsByBarId(id);
  }
}
