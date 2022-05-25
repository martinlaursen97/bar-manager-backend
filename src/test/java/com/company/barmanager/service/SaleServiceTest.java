package com.company.barmanager.service;

import com.company.barmanager.dto.ItemDTO;
import com.company.barmanager.dto.TypeDTO;
import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.exception.TypeAlreadyExistsException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.model.Item;
import com.company.barmanager.model.Sale;
import com.company.barmanager.model.Type;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SaleService.class)
class SaleServiceTest {

    @Autowired
    SaleService saleService;

    @Autowired
    BarService barService;

    @Autowired
    TypeService typeService;

    @Autowired
    ItemService itemService;

    @Test
    void save() {
        Sale sale = new Sale();
        Sale saved = saleService.save(sale);
        Assertions.assertNotNull(saved);
    }

    @Test
    void findAll() {
        List<Sale> sales = saleService.findAll();
        Assertions.assertNotNull(sales);
    }

    @Test
    void getSalesByBarId() throws BarNameTakenException {
        Bar bar = new Bar();
        Sale sale = new Sale();

        Bar savedBar = barService.save(bar);

        sale.setBar(savedBar);

        saleService.save(sale);

        List<Sale> found = saleService.getSalesByBarId(savedBar.getId());

        Assertions.assertNotNull(found);
    }

    @Test
    void getSalesByDateAndBarId() throws BarNameTakenException {
        Bar bar = new Bar();
        Sale sale = new Sale();

        LocalDate ld = LocalDate.now();
        sale.setSaleDate(ld);

        Bar savedBar = barService.save(bar);

        sale.setBar(savedBar);

        saleService.save(sale);

        List<Sale> found = saleService.getSalesByDateAndBarId(
                sale.getId(),
                LocalDate.now(),
                LocalDate.now());

        Assertions.assertNotNull(found);

    }

    @Test
    void findBySaleDateAndBarId() throws BarNameTakenException {
        Bar bar = new Bar();
        Sale sale = new Sale();

        LocalDate ld = LocalDate.now();
        sale.setSaleDate(ld);

        Bar savedBar = barService.save(bar);

        sale.setBar(savedBar);

        saleService.save(sale);

        List<Sale> found = saleService.findBySaleDateAndBarId(
                sale.getId(),
                LocalDate.now());

        Assertions.assertNotNull(found);

    }

    @Test
    void deleteSaleById() {
        Sale sale = new Sale();
        Sale saved = saleService.save(sale);
        Long id = saved.getId();

        saleService.deleteSaleById(id);
        Assertions.assertThrows(ChangeSetPersister.NotFoundException.class, () -> saleService.findBySaleId(id));
    }

    @Test
    void getTypeDTOByBarId() throws BarNameTakenException, TypeAlreadyExistsException {


        Type type = new Type();
        Type savedType = typeService.save(type);
        Bar bar = new Bar();
        Sale sale = new Sale();

        LocalDate ld = LocalDate.now();
        sale.setSaleDate(ld);

        Bar savedBar = barService.save(bar);

        Item i1 = new Item();
        i1.setType(savedType);
        i1.setBar(savedBar);
        itemService.save(i1);

        sale.setBar(savedBar);

        saleService.save(sale);

        List<TypeDTO> found = saleService.getTypeDTOByBarId(savedBar.getId(), LocalDate.now(), LocalDate.now());

        Assertions.assertNotNull(found);
    }
}