package com.company.barmanager.service;

import com.company.barmanager.exception.TypeAlreadyExistsException;
import com.company.barmanager.model.Item;
import com.company.barmanager.model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TypeService.class)
class TypeServiceTest {

  @Autowired
  TypeService typeService;
  /*
  List<Item> items = itemService.findAll();
  int size = items.size();

  Item item = new Item();
  Item saved = itemService.save(item);
        itemService.deleteById(saved.getId());

        Assertions.assertNotEquals(0, size);
}

   */


  @Test
  void save() throws TypeAlreadyExistsException {
    Type type = new Type();
    Type saved = typeService.save(type);
    Assertions.assertNotNull(saved);



  }


  @Test
  void findAll() throws TypeAlreadyExistsException {
    Type type = new Type();
    typeService.save(type);
    List<Type> types = typeService.findAll();

  Assertions.assertNotNull(types);



  }


}