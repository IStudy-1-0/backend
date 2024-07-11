package com.aziz.certificateservice.repositories;

import com.aziz.certificateservice.models.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificatRepo extends JpaRepository<Certificat, Long> {
}
