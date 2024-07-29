package com.dayanalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudyDayDto {
    private String date;
    private Integer rating;
    private String type;
    private Integer userId;
}
