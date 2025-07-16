package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skill_id;

    private String skill_name;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
