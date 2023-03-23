package com.example.tuanvm4rest.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "weather", schema = "public", catalog = "postgres")
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTempLo() {
        return tempLo;
    }

    public void setTempLo(Integer tempLo) {
        this.tempLo = tempLo;
    }

    public Integer getTempHi() {
        return tempHi;
    }

    public void setTempHi(Integer tempHi) {
        this.tempHi = tempHi;
    }

    public Float getPrcp() {
        return prcp;
    }

    public void setPrcp(Float prcp) {
        this.prcp = prcp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherEntity that = (WeatherEntity) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (tempLo != null ? !tempLo.equals(that.tempLo) : that.tempLo != null) return false;
        if (tempHi != null ? !tempHi.equals(that.tempHi) : that.tempHi != null) return false;
        if (prcp != null ? !prcp.equals(that.prcp) : that.prcp != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (tempLo != null ? tempLo.hashCode() : 0);
        result = 31 * result + (tempHi != null ? tempHi.hashCode() : 0);
        result = 31 * result + (prcp != null ? prcp.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
