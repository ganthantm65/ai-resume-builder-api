package com.example.server.service;

import com.example.server.model.Resume;
import com.example.server.repository.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepo resumeRepo;

    public Resume addResume(Resume resume){
        return resumeRepo.save(resume);
    }

    public Integer getNoOfResumes(int user_id){
        return resumeRepo.findByUserId(user_id).size();
    }


}
