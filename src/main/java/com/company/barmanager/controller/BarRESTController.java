package com.company.barmanager.controller;

import com.company.barmanager.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/bar")
public class BarRESTController {

    private final BarService barService;

    @Autowired
    public BarRESTController(BarService barService){
        this.barService = barService;
    }
}
