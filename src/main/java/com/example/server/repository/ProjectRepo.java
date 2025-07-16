package com.example.server.repository;

import com.example.server.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Projects,Integer> {
}
