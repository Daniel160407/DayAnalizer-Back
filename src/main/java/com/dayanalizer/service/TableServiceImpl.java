package com.dayanalizer.service;

import com.dayanalizer.dto.TableDto;
import com.dayanalizer.model.Table;
import com.dayanalizer.model.User;
import com.dayanalizer.repository.DayRepository;
import com.dayanalizer.repository.TablesRepository;
import com.dayanalizer.repository.UsersRepository;
import com.dayanalizer.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final TablesRepository tablesRepository;
    private final UsersRepository usersRepository;
    private final DayRepository dayRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public TableServiceImpl(TablesRepository tablesRepository, UsersRepository usersRepository, DayRepository dayRepository, ModelConverter modelConverter) {
        this.tablesRepository = tablesRepository;
        this.usersRepository = usersRepository;
        this.dayRepository = dayRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<TableDto> getTables(String email) {
        User user = usersRepository.findByEmail(email);
        return modelConverter.convertTablesToDtoList(tablesRepository.findAllByUserId(user.getId()));
    }

    @Override
    public List<TableDto> addTable(TableDto tableDto) {
        User user = usersRepository.findByEmail(tableDto.getUserEmail());
        Table table = modelConverter.convert(tableDto);
        table.setUserId(user.getId());
        tablesRepository.save(table);
        return modelConverter.convertTablesToDtoList(tablesRepository.findAllByUserId(user.getId()));
    }

    @Override
    public List<TableDto> editTable(TableDto tableDto, TableDto updatedTableDto) {
        User user = usersRepository.findByEmail(tableDto.getUserEmail());
        Table table = tablesRepository.findByName(tableDto.getName());
        table.setName(updatedTableDto.getName());
        table.setQuestion(updatedTableDto.getQuestion());
        table.setUserId(user.getId());
        tablesRepository.save(table);
        return modelConverter.convertTablesToDtoList(tablesRepository.findAllByUserId(user.getId()));
    }

    @Override
    public List<TableDto> deleteTable(String email, String name) {
        User user = usersRepository.findByEmail(email);
        tablesRepository.deleteByNameAndUserId(name, user.getId());
        dayRepository.deleteByTypeAndUserId(name, user.getId());
        return modelConverter.convertTablesToDtoList(tablesRepository.findAllByUserId(user.getId()));
    }
}
