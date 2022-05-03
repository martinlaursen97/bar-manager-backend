package com.company.barmanager.service;

import com.company.barmanager.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class BarService {


    private final BarRepository barRepository;

    @Autowired
    public BarService barService(BarRepository barRepository){
        this.barRepository = barRepository;
    }
}
