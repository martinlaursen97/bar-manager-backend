package com.company.barmanager.service;

import com.company.barmanager.exception.BarNameTakenException;
import com.company.barmanager.exception.BarNotFoundException;
import com.company.barmanager.model.Bar;
import com.company.barmanager.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Bar save(Bar bar) throws BarNameTakenException {
        if (barRepository.findBarByBarName(bar.getBarName()).isEmpty()) {
            return barRepository.save(bar);
        } else {

            throw new BarNameTakenException("Bar name already exists");
        }
    }



    public Bar findById(Long id) throws BarNotFoundException {
        return barRepository.findById(id).orElseThrow(
                () -> new BarNotFoundException("Bar not found")
        );
    }
}
