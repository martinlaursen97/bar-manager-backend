package com.company.barmanager.controller;

import com.company.barmanager.model.Bar;
import com.company.barmanager.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/bar")
public class BarRESTController {

    private final BarService barService;

    @Autowired
    public BarRESTController(BarService barService){
        this.barService = barService;
    }

    @GetMapping
    public ResponseEntity<List<Bar>> getBars(){
        return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
    }

}
