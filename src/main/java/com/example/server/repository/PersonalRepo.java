package com.example.server.repository;

import com.example.server.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepo extends JpaRepository<PersonalInfo,Integer> {
}
