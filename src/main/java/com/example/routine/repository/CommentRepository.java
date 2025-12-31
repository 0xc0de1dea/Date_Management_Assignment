package com.example.routine.repository;

import com.example.routine.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    boolean existsById(Long id);

    @Query("SELECT c FROM Comment c WHERE c.date.id = :dateId")
    List<Comment> findByDateId(@Param("dateId") Long dateId);
}
