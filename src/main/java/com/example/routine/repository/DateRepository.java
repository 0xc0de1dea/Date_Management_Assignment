package com.example.routine.repository;

import com.example.routine.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DateRepository extends JpaRepository<Date, Long> {
    boolean existsById(Long id);

    List<Date> findAllByAuthor(String author);
}
