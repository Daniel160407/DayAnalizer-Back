package com.dayanalizer.service;

import com.dayanalizer.dto.TableDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {
    List<TableDto> getTables(String email);

    List<TableDto> addTable(TableDto tableDto);

    List<TableDto> editTable(TableDto tableDto, TableDto updatedTableDto);

    List<TableDto> deleteTable(String email, String name);
}
