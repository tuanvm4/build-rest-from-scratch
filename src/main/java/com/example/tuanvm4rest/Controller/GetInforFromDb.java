package com.example.tuanvm4rest.Controller;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import com.example.tuanvm4rest.Entity.WeatherEntity;
import com.example.tuanvm4rest.Repository.Cities;
import com.example.tuanvm4rest.Repository.Weather;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetInforFromDb {
    private static final Logger logger = LoggerFactory.getLogger(GetInforFromDb.class);
   @Autowired
    private Weather weather;
//    @Autowired
    private  Cities cities;

    @GetMapping("/get-weather-by-city")
    public List<WeatherEntity> getByName(String cityName) {
        List<WeatherEntity> res = weather.getByCity(cityName);
        return res;

    }

    @PostMapping("/random-param-city-save")
    public void saveWeatherByCity(String... param1) {
        try {
            List<CitiesEntity> myList = cities.findAllByNameIsNotNull();
            logger.info("myList");
        }
        catch (Exception e) {
            logger.error("This method exception {}", e.getMessage());
        }
    }

}
