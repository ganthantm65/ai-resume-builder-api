package com.example.server.service;

import com.example.server.model.Certification;
import com.example.server.repository.CertificateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CertificationService {
    @Autowired
    private CertificateRepo certificateRepo;

    public void addCertification(List<Certification> certification){
        certificateRepo.saveAll(certification);
    }
}
