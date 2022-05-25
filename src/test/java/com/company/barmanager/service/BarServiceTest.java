package com.company.barmanager.service;

import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.exception.BarNotFoundException;
import com.company.barmanager.model.Bar;
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
@Import(BarService.class)
class BarServiceTest {

    @Autowired
    BarService barService;

    @Test
    void findAll() {
        List<Bar> foundBar = barService.findAll();

        Assertions.assertNotNull(foundBar);
        Assertions.assertEquals(2, foundBar.size());
    }

    @Test
    void save() {
        Bar bar = new Bar();
        assertNotNull(bar);
    }

    @Test
    void findById() throws BarNameTakenException, BarNotFoundException {
        Bar bar = new Bar();
        Bar savedBar = barService.save(bar);

        Long id = savedBar.getId();

        Assertions.assertNotNull(barService.findById(id));

    }

}