package com.example.server.repository;

import com.example.server.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skills,Integer> {
}
