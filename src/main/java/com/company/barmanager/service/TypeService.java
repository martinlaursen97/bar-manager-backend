package com.company.barmanager.service;

import com.company.barmanager.exception.TypeAlreadyExistsException;
import com.company.barmanager.model.Type;
import com.company.barmanager.repository.BarRepository;
import com.company.barmanager.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

  private final TypeRepository typeRepository;

  @Autowired

  public TypeService(TypeRepository typeRepository){
    this.typeRepository = typeRepository;
  }

  public List<Type> findAll(){
   return typeRepository.findAll();
  }

  public Type save(Type type) throws TypeAlreadyExistsException {
    if (typeRepository.findTypeByTypeName(type.getTypeName()).isEmpty()) {
      return typeRepository.save(type);
    } else {
      throw new TypeAlreadyExistsException("");
    }
  }
}
