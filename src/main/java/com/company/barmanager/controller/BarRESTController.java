package com.company.barmanager.controller;

import com.company.barmanager.exception.BarNotFoundException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/bars")
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

    @GetMapping("/{id}")
    public ResponseEntity<Bar> getBarById(@PathVariable Long id) throws BarNotFoundException {
        return new ResponseEntity<>(barService.findById(id), HttpStatus.OK);
    }

}
