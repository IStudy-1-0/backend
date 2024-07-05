package com.arij.courseservice.repository;

import com.arij.courseservice.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeanceRepo extends JpaRepository<Seance,Long> {

}