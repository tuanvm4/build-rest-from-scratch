package com.example.tuanvm4rest.Repository;

import com.example.tuanvm4rest.Entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Weather extends JpaRepository<WeatherEntity, Integer> {
    @Query(value = "select * from weather where city like %?1%", nativeQuery = true)
    List<WeatherEntity> getByCity(String city);
}
