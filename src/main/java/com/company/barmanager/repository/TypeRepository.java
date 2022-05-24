package com.company.barmanager.repository;


import com.company.barmanager.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

  @Query("SELECT t FROM Type t WHERE t.typeName = ?1")
  Optional<Type> findTypeByTypeName(String typeName);
}



