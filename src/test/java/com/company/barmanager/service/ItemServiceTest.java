package com.company.barmanager.service;


import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.exception.LoginException;
import com.company.barmanager.exception.TypeAlreadyExistsException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.model.Item;
import com.company.barmanager.model.Type;
import com.company.barmanager.repository.ItemRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ItemService.class)
class  ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    BarService barService;

    @Autowired
    TypeService typeService;

    @Test
    void findByBarId() {
        List<Item> items = itemService.getItemsByBarId(1L);
        Assertions.assertNotNull(items);

    }

    @Test
    void save() {
        Item item = new Item();
        Item saved = itemService.save(item);
        itemService.deleteById(saved.getId());
        Assertions.assertNotNull(saved);

    }

    @Test
    void findAll() {
        List<Item> items = itemService.findAll();
        int size = items.size();

        Item item = new Item();
        Item saved = itemService.save(item);
        itemService.deleteById(saved.getId());

        Assertions.assertNotEquals(0, size);
    }

    @Test
    void deleteById() throws ChangeSetPersister.NotFoundException {
        Item item = new Item();
        Item saved = itemService.save(item);
        Long id = saved.getId();

        itemService.deleteById(id);
        Assertions.assertThrows(ChangeSetPersister.NotFoundException.class, () -> itemService.findById(id));
    }

    @Test
    void getItemsByBarId() throws BarNameTakenException {
        Item i1 = new Item();
        List<Item> items = new ArrayList<>();
        items.add(i1);

        Bar bar = new Bar();
        bar.setItems(items);


        Bar saved = barService.save(bar);
        i1.setBar(saved);
        itemService.save(i1);

        List<Item> found = itemService.getItemsByBarId(saved.getId());

        Assertions.assertNotEquals(0, found.size());

    }

    @Test
    void getItemsByItemNameAndBarIdAndTypeId() throws BarNameTakenException, TypeAlreadyExistsException {
        Type type = new Type();
        Type savedType = typeService.save(type);

        Item i1 = new Item();
        i1.setItemName("testName");
        i1.setType(savedType);

        List<Item> items = new ArrayList<>();
        items.add(i1);

        Bar bar = new Bar();
        bar.setItems(items);
        Bar savedBar = barService.save(bar);

        i1.setBar(savedBar);
        itemService.save(i1);

        List<Item> found = itemService.getItemsByItemNameAndBarIdAndTypeId(
                "testName",
                savedBar.getId(),
                savedType.getId());

        Assertions.assertNotEquals(0, found.size());


    }

    @Test
    void getItemsByItemNameAndBarId() throws BarNameTakenException {
        Item i1 = new Item();
        i1.setItemName("testName");

        List<Item> items = new ArrayList<>();
        items.add(i1);

        Bar bar = new Bar();
        bar.setItems(items);
        Bar savedBar = barService.save(bar);

        i1.setBar(savedBar);
        itemService.save(i1);

        List<Item> found = itemService.getItemsByItemNameAndBarId(
                "testName",
                savedBar.getId());

        Assertions.assertNotEquals(0, found.size());

    }

    @Test
    void getItemsByBarIdAndTypeId() throws TypeAlreadyExistsException, BarNameTakenException {
        Type type = new Type();
        Type savedType = typeService.save(type);

        Item i1 = new Item();
        i1.setType(savedType);

        List<Item> items = new ArrayList<>();
        items.add(i1);

        Bar bar = new Bar();
        bar.setItems(items);
        Bar savedBar = barService.save(bar);

        i1.setBar(savedBar);
        itemService.save(i1);

        List<Item> found = itemService.getItemsByBarIdAndTypeId(
                savedBar.getId(),
                savedType.getId());

        Assertions.assertNotEquals(0, found.size());


    }

    @Test
    void setActiveById() throws ChangeSetPersister.NotFoundException {
        Item item = new Item();
        item.setIsActive(true);
        Item savedItem = itemService.save(item);

        itemService.setActiveById(savedItem.getId());

        Item savedItem2 = itemService.findById(savedItem.getId());

        Assertions.assertFalse(savedItem2.getIsActive());
    }

    @Test
    void getActiveItemsByBarId() throws BarNameTakenException {
        Item item = new Item();
        Item itemFalse = new Item();
        item.setIsActive(true);
        itemFalse.setIsActive(false);

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(itemFalse);

        Bar bar = new Bar();
        bar.setItems(items);

        Bar savedBar = barService.save(bar);

        item.setBar(savedBar);
        itemFalse.setBar(savedBar);

        itemService.save(item);
        itemService.save(itemFalse);

        Assert.assertEquals(1, itemService.getActiveItemsByBarId(savedBar.getId()).size());
    }
}