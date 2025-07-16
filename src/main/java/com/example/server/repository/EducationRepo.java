package com.example.server.repository;

import com.example.server.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education,Integer> {
}
