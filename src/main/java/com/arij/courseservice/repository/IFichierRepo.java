package com.arij.courseservice.repository;

import com.arij.courseservice.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFichierRepo extends JpaRepository<Fichier,Long> {
}
