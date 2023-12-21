package com.example.tuanvm4rest.Controller;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import com.example.tuanvm4rest.Entity.WeatherEntity;
import com.example.tuanvm4rest.Repository.Cities;
import com.example.tuanvm4rest.Repository.Weather;
import com.example.tuanvm4rest.Service.RandomWeatherGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GetInforController {
    @Autowired
    private Weather weather;
    //    @Autowired
    private final Cities cities;
    private final RandomWeatherGenerator randomWeatherGenerator;

    @GetMapping("/get-weather-by-city")
    public ResponseEntity<List<WeatherEntity>> getByName(String cityName) {
        // Todo: Somehow this list return data but the actual response is list with same size but empty json on each element
        List<WeatherEntity> res = weather.getByCity("tet");
        return ResponseEntity.ok(res);
    }

    @PostMapping("/random-param-city-save")
    public void saveWeatherByCity(String... param1) {
        try {
            log.info("myList");
            List<WeatherEntity> res = randomWeatherGenerator.getRandomWeather("cityName", "test");
            weather.saveAll(res);
        } catch (Exception e) {
            log.error("This method exception {}", e.getMessage());
        }
    }
}
