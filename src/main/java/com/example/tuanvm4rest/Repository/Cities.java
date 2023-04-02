package com.example.tuanvm4rest.Repository;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Cities extends JpaRepository<CitiesEntity, Long> {
    List<CitiesEntity> findAllByNameIsNotNull();


}
