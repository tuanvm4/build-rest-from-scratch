package com.example.tuanvm4rest.Service;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import com.example.tuanvm4rest.Entity.WeatherEntity;
import com.example.tuanvm4rest.Repository.Cities;
import com.example.tuanvm4rest.Repository.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class RandomWeatherGenerator {
    @Autowired
    private Weather weather;

    @Autowired
    private Cities cities;

    public List<WeatherEntity> getRandomWeather(String... value) {
        try {
            List<WeatherEntity> res = new ArrayList<>();

            // Add a WeatherEntity with random values to the list
            int i = 100;
            while (i-- != 0) {
                WeatherEntity randomWeather = createRandomWeather();
                res.add(randomWeather);
            }
            return res;
        } catch (Exception e) {
            log.error("Exception occurred in this method: {}", e.getMessage());
            // Handle the exception or return an error response
            return Collections.emptyList(); // For simplicity, returning an empty list in case of an exception
        }
    }

    private WeatherEntity createRandomWeather() {
        // Assuming WeatherEntity has a constructor that takes necessary parameters
        Random random = new Random();
        double temperature = random.nextDouble() * 100; // Random temperature between 0 and 100
        double humidity = random.nextDouble(); // Random humidity between 0 and 1
        // Add other random values as needed

        return WeatherEntity.builder().prcp((float) humidity).tempHi((int) temperature).tempLo((int) temperature - 10)
                .city(UUID.randomUUID().toString()).date(Date.valueOf(LocalDate.now())).build();
    }
}
