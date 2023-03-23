package com.example.tuanvm4rest.Controller;

import com.example.tuanvm4rest.Entity.WeatherEntity;
import com.example.tuanvm4rest.Repository.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetInforFromDb {
    @Autowired
    private Weather weather;

    @GetMapping("/get-weather-by-city")
    public WeatherEntity getByName(String cityName) {
        List<WeatherEntity> res = weather.getByCity(cityName);
        return res.get(0);

    }

}
