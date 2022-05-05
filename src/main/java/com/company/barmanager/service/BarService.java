package com.company.barmanager.service;

import com.company.barmanager.model.Bar;
import com.company.barmanager.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class BarService {
    private final BarRepository barRepository;

    @Autowired
    public BarService(BarRepository barRepository){
        this.barRepository = barRepository;
    }


    public List<Bar> findAll() {
        return barRepository.findAll();
    }
}
