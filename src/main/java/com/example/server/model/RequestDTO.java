package com.example.server.model;

import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {
    private PersonalInfo personalInfo;
    private List<Education> educations;
    private List<Skills> skills;
    private List<Projects> projects;
    private List<WorkExperience> workExperiences;
    private List<Certification> certifications;
}
