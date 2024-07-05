package com.arij.courseservice.repository;

import com.arij.courseservice.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepo extends JpaRepository<File,Long> {
}
