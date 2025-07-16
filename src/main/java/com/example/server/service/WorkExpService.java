package com.example.server.service;

import com.example.server.model.WorkExperience;
import com.example.server.repository.WorkExpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkExpService {
    @Autowired
    private WorkExpRepo workExpRepo;

    public void addWordExperience(List<WorkExperience> workExperience){
        workExpRepo.saveAll(workExperience);
    }
}
