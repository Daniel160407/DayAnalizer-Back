package com.dayanalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableDto {
    private String name;
    private String question;
    private String userEmail;

    public TableDto(String name, String question) {
        this.name = name;
        this.question = question;
    }
}
