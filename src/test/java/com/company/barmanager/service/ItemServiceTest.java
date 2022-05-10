package com.company.barmanager.service;


import com.company.barmanager.model.Item;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ItemService.class)
class  ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void findByBarId() {
        List<Item> items = itemService.getItemsByBarId(1L);
        Assertions.assertNotNull(items);

    }
}