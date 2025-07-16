package com.example.server.controller;

import com.example.server.model.RequestDTO;
import com.example.server.model.Resume;
import com.example.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private EducationalService educationalService;

    @Autowired
    private SkillsService skillsService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkExpService workExpService;

    @Autowired
    private CertificationService certificationService;

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/create")
    public Resume createResume(@RequestBody Resume resume){
        return resumeService.addResume(resume);
    }

    @PostMapping("/generate")
    public String generateResume(@RequestBody RequestDTO requestDTO){
        personalService.addPersonalDetails(requestDTO.getPersonalInfo());
        educationalService.addEducation(requestDTO.getEducations());
        skillsService.addSkills(requestDTO.getSkills());
        projectService.addProjects(requestDTO.getProjects());
        workExpService.addWordExperience(requestDTO.getWorkExperiences());
        certificationService.addCertification(requestDTO.getCertifications());

        return geminiService.generateFromDTO(requestDTO);
    }

    @GetMapping("/noOfResume/{user_id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getNoOfResumes(@PathVariable int user_id){
        int no=resumeService.getNoOfResumes(user_id);
        Map<String,Integer> noOfResumes=new HashMap<>();

        noOfResumes.put("Number",no);

        return ResponseEntity.ok(noOfResumes);
    }

}
