package com.company.barmanager.controller;

import com.company.barmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/item")
public class ItemRESTController {

  private final ItemService itemService;

  @Autowired
  public Item
}
