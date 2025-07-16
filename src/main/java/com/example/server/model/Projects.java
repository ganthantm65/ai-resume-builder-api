package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    private String title;

    private String description;

    private String repo_url;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
