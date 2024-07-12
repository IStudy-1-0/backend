package com.aziz.certificateservice.repositories;

import com.aziz.certificateservice.models.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepo extends JpaRepository<Certificat, Long> {
}
