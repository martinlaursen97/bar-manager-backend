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
}
