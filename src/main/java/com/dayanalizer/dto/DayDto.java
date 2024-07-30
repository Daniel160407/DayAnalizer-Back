package com.dayanalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayDto {
    private String date;
    private Integer rating;
    private String type;
    private String userEmail;

    public DayDto(String date, Integer rating, String type) {
        this.date = date;
        this.rating = rating;
        this.type = type;
    }
}
