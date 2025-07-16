package com.example.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resume_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String date;
}
