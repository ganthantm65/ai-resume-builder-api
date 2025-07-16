package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int edu_id;

    private String graduation;

    private String institution;

    private String start_year;

    private String end_year;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
