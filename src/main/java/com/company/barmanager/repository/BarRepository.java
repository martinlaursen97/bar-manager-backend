package com.company.barmanager.repository;

import com.company.barmanager.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {

    @Query("SELECT b FROM Bar b WHERE b.barName = ?1")
    Optional<Bar> findBarByBarName(String barName);
}
