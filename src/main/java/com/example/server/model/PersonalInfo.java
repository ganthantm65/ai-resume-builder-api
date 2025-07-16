package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "personal_info")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personal_id;

    private String name;

    private String role;

    private String email_id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    private String linked_url;

    private String github_url;
}
