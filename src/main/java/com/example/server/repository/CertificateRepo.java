package com.example.server.repository;

import com.example.server.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepo extends JpaRepository<Certification,Integer> {
}
