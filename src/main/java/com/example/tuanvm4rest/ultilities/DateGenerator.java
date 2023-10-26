package com.example.tuanvm4rest.ultilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DateGenerator {
    public static List<LocalDate> getWeekendDays(int year) {

        long startTime = System.currentTimeMillis();

        List<LocalDate> weekends = new ArrayList<>();

        Year y = Year.of(year);
        LocalDate startDate = y.atDay(1);

        while(startDate.getYear() == year) {
            if(startDate.getDayOfWeek() == DayOfWeek.SATURDAY
                    || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends.add(startDate);
            }
            startDate = startDate.plusDays(1);
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to get weekends: " + timeTaken + " ms");

        return weekends;
    }

    public static void main(String[] args) {

        List<LocalDate> weekends = getWeekendDays(2023);
        weekends.forEach(date -> System.out.println(date));

    }
}
