package com.dayanalizer.repository;

import com.dayanalizer.model.StudyDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyDayRepository extends JpaRepository<StudyDay, Integer> {
    List<StudyDay>findAllByUserId(int userId);
}
