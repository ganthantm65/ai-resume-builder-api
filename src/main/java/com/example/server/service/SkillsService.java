package com.example.server.service;

import com.example.server.model.Skills;
import com.example.server.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsService {
    @Autowired
    private SkillRepo skillRepo;

    public void addSkills(List<Skills> skills){
        skillRepo.saveAll(skills);
    }
}
