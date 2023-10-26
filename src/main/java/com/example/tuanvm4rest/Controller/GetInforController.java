package com.example.tuanvm4rest.Controller;

import com.example.tuanvm4rest.Entity.CitiesEntity;
import com.example.tuanvm4rest.Entity.WeatherEntity;
import com.example.tuanvm4rest.Repository.Cities;
import com.example.tuanvm4rest.Repository.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class GetInforController {
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
            log.info("myList");
        }
        catch (Exception e) {
            log.error("This method exception {}", e.getMessage());
        }
    }

//    public void addPermission(final TypePermission permission) {
//        if (permission.equals(NoTypePermission.NONE) || permission.equals(AnyTypePermission.ANY))
//            permissions.clear();
//        permissions.add(0, permission);
//    }
//
//    public Class realClass(final String elementName) {
//        final Class type = super.realClass(elementName);
//        for (int i = 0; i < permissions.size(); ++i) {
//            final TypePermission permission = (TypePermission)permissions.get(i);
//            if (permission.allows(type))
//                return type;
//        }
//        throw new ForbiddenClassException(type);
//    }
//
//    public void addPermission(final TypePermission permission) {
//        if (permission.equals(NoTypePermission.NONE) || permission.equals(AnyTypePermission.ANY))
//            permissions.clear();
//        permission.add(0,permission)
//    }

}
