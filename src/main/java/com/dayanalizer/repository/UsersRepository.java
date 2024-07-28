package com.dayanalizer.repository;

import com.dayanalizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
}
