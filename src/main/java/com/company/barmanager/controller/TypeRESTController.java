package com.company.barmanager.controller;

import com.company.barmanager.exception.TypeAlreadyExistsException;
import com.company.barmanager.model.Type;
import com.company.barmanager.service.TypeService;
import com.company.barmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/types")
public class TypeRESTController {

  private final TypeService typeService;

  @Autowired
  public TypeRESTController(TypeService typeService) {
    this.typeService = typeService;
  }

  @GetMapping
  public ResponseEntity<List<Type>> getAllTypes(){
    return new ResponseEntity<>(typeService.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Type> createType(@RequestBody Type type) throws TypeAlreadyExistsException {
    return new ResponseEntity<>(typeService.save(type), HttpStatus.OK);
  }

}
