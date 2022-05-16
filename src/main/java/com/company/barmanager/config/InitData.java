package com.company.barmanager.config;

import com.company.barmanager.model.Bar;
import com.company.barmanager.model.Item;
import com.company.barmanager.model.Type;
import com.company.barmanager.model.User;
import com.company.barmanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ItemService itemService;
    @Autowired
    BarService barService;
    @Autowired
    SaleLineItemService saleLineItemService;
    @Autowired
    SaleService saleService;
    @Autowired
    UserService userService;
    @Autowired
    TypeService typeService;

    @Override
    public void run(String... args) throws Exception {
        Type type1 = new Type();
        type1.setTypeName("Shots");
        typeService.save(type1);

        Type type2 = new Type();
        type2.setTypeName("Beer");
        typeService.save(type2);

        Type type3 = new Type();
        type3.setTypeName("Mixer");
        typeService.save(type3);

        Type type4 = new Type();
        type4.setTypeName("Spiritus");
        typeService.save(type4);


        User user = new User();
        user.setUsername("admin");
        user.setPassword("password");
        userService.save(user);
        Bar bar1 = new Bar();




        bar1.setBarName("Brygger hesten");

        Item i1 = new Item();
        i1.setAmountNo(5);
        i1.setBar(bar1);
        i1.setItemName("Tuborg");
        i1.setType(type2);

        Item i2 = new Item();
        i2.setAmountNo(52);
        i2.setBar(bar1);
        i2.setItemName("Vodka");
        i2.setType(type4);

        Item i3 = new Item();
        i3.setAmountNo(2);
        i3.setBar(bar1);
        i3.setItemName("Jägger meister");
        i3.setType(type1);

        Item i4 = new Item();
        i4.setAmountNo(123);
        i4.setBar(bar1);
        i4.setItemName("Cola");
        i4.setType(type3);

        Item i5 = new Item();
        i5.setAmountNo(23);
        i5.setBar(bar1);
        i5.setItemName("Carlsberg");
        i5.setType(type2);

        Item i6 = new Item();
        i6.setAmountNo(23);
        i6.setBar(bar1);
        i6.setItemName("Blanc 1664");
        i6.setType(type2);

        List<Item> items1 = new ArrayList<>();
        items1.add(i1);
        items1.add(i2);
        items1.add(i3);
        items1.add(i4);
        items1.add(i5);
        items1.add(i6);




        barService.save(bar1);
        itemService.save(i1);
        itemService.save(i2);
        itemService.save(i3);
        itemService.save(i4);
        itemService.save(i5);
        itemService.save(i6);

        Bar bar2 = new Bar();

        bar2.setBarName("alpehytten");

        Item j1 = new Item();
        j1.setAmountNo(25);
        j1.setBar(bar2);
        j1.setItemName("Heineken");
        j1.setType(type1);

        Item j2 = new Item();
        j2.setAmountNo(19);
        j2.setBar(bar2);
        j2.setItemName("Vodka");
        j2.setType(type4);

        Item j3 = new Item();
        j3.setAmountNo(3);
        j3.setBar(bar2);
        j3.setItemName("Jägger Meister");
        j3.setType(type1);

        Item j4 = new Item();
        j3.setAmountNo(17);
        j3.setBar(bar2);
        j3.setItemName("Sweppes Lemon");
        j3.setType(type4);

        List<Item> items2 = new ArrayList<>();
        items2.add(j1);
        items2.add(j2);
        items2.add(j3);
        items2.add(j4);



        barService.save(bar2);
        itemService.save(j1);
        itemService.save(j2);
        itemService.save(j3);
        itemService.save(j4);

    }
}