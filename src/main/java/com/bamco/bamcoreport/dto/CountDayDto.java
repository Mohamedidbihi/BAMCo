package com.bamco.bamcoreport.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Count", description = "Count Properties")
public class CountDayDto {
    private String day;
    private int count;

    public CountDayDto(String day, int count){
        this.day = day;
        this.count = count;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountDayDto{" +
                "day='" + day + '\'' +
                ", count=" + count +
                '}';
    }
}
