package com.arij.courseservice.repository;

import com.arij.courseservice.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepo extends JpaRepository<Image,String> {
 void deleteImageById(String idImage);
}
