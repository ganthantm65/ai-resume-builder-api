package com.example.server.repository;

import com.example.server.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ResumeRepo extends JpaRepository<Resume,Integer> {
    @Query("SELECT r FROM Resume r WHERE r.user.user_id = :userId")
    List<Resume> findByUserId(@Param("userId") int userId);

}
