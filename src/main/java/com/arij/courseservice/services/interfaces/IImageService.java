package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface IImageService {
    Image uploadImageAndAffectToCourse(Image image, Long idCourse) throws IOException;
    Optional<Image> getOne(String idImage);
    void  deleteImageById(String idImage );


}
