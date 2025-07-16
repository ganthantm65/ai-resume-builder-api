package com.example.server.repository;

import com.example.server.model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExpRepo extends JpaRepository<WorkExperience,Integer> {
}
