package com.dayanalizer.repository;

import com.dayanalizer.model.Day;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Integer> {
    List<Day> findAllByUserIdAndType(int userId, String type);

    Day findByUserIdAndTypeAndDate(int userId, String type, String date);

    @Transactional
    void deleteByTypeAndUserId(String type, Integer userId);
}
