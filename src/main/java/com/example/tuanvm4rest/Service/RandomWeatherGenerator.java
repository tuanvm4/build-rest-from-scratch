package com.example.tuanvm4rest.Service;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import com.example.tuanvm4rest.Repository.Cities;
import com.example.tuanvm4rest.Repository.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomWeatherGenerator {
    @Autowired
    private Weather weather;

    @Autowired
    private Cities cities;

    private void randInsert(String... value) {
        List<CitiesEntity> allOfTheList = new ArrayList<>();
        List<CitiesEntity> citiesEntityList = cities.findAllByNameIsNotNull();
        allOfTheList.addAll(citiesEntityList);

    }
}
