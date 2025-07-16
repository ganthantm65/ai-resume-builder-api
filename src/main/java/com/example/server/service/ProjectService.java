package com.example.server.service;

import com.example.server.model.Projects;
import com.example.server.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public void addProjects(List<Projects> projects){
        projectRepo.saveAll(projects);
    }
}
