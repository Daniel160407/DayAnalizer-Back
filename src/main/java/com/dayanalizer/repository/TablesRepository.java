package com.dayanalizer.repository;

import com.dayanalizer.model.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesRepository extends JpaRepository<Table, Integer> {
    List<Table> findAllByUserId(Integer id);

    Table findByName(String name);

    @Transactional
    void deleteByNameAndUserId(String name, Integer userId);
}
