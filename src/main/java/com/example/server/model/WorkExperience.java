package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "work_experience")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exp_id;

    private String company_name;

    private String role;

    private String employee_type;

    private String work_mode;

    private String duration;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
