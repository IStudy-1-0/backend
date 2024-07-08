package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IVideoService {
    List<Video> uploadVideoAndAffectToCourse(List<Video> videos, Long idCourse) throws IOException;
    Optional<Video> getOne(String idVideo);
    void  deleteVideoById(String idVideo );

}
