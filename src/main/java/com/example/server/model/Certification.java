package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "certification")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cert_id;

    private String course_name;

    private String institution;

    private String duration;
}
