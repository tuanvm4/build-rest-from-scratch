package com.example.tuanvm4rest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "weather", schema = "tuanvm_application", catalog = "develop")
public class WeatherEntity {
    @Basic
    @Id
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "temp_lo")
    private Integer tempLo;
    @Basic
    @Column(name = "temp_hi")
    private Integer tempHi;
    @Basic
    @Column(name = "prcp")
    private Float prcp;
    @Basic
    @Column(name = "date")
    private Date date;

}
