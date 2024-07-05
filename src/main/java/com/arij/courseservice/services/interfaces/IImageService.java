package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.File;
import com.arij.courseservice.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {
    String uploadAndSaveImage(MultipartFile multipartFile) throws IOException ;
    Image deleteImage(Image img);
    void deleteImageWithId(long id);
    void  deleteImageWithName(String name);
    Image updateImage(Image img);
    Image updateImageWithName(String name);
    List<Image> getListImage();
    Image getImageWithName(String name);

}
