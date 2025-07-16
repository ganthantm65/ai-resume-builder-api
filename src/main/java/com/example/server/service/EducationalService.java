package com.example.server.service;

import com.example.server.model.Education;
import com.example.server.repository.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationalService {
    @Autowired
    private EducationRepo educationRepo;

    public void addEducation(List<Education> education){
        educationRepo.saveAll(education);
    }
}
