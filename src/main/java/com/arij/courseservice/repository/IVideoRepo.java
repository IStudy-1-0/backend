package com.arij.courseservice.repository;

import com.arij.courseservice.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepo extends JpaRepository<Video,String> {
    void deleteVideoById(String idVideo);

}
