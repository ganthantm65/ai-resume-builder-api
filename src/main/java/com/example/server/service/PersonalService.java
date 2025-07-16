package com.example.server.service;

import com.example.server.model.PersonalInfo;
import com.example.server.repository.PersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalService {
    @Autowired
    private PersonalRepo personalRepo;

    public void addPersonalDetails(PersonalInfo personalInfo){
        personalRepo.save(personalInfo);
    }
}
