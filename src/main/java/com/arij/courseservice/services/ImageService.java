package com.arij.courseservice.services;

import com.arij.courseservice.entities.Image;
import com.arij.courseservice.repository.IImageRepo;
import com.arij.courseservice.services.interfaces.IFileUploadService;
import com.arij.courseservice.services.interfaces.IImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class ImageService implements IImageService {

    private final IImageRepo imageRepository;
    private final IFileUploadService fileUpload;
    @Override
    public String uploadAndSaveImage(MultipartFile multipartFile) throws IOException {
        String imageURL = fileUpload.uploadFile(multipartFile);
        Image image = new Image();
        image.setUrl(imageURL);
        image.setName(multipartFile.getOriginalFilename());
        imageRepository.save(image);
        return imageURL;
    }

    @Override
    public Image deleteImage(Image img) {
        return null;
    }

    @Override
    public void deleteImageWithId(long id) {

    }

    @Override
    public void deleteImageWithName(String name) {

    }

    @Override
    public Image updateImage(Image img) {
        return null;
    }

    @Override
    public Image updateImageWithName(String name) {
        return null;
    }

    @Override
    public List<Image> getListImage() {
        return null;
    }

    @Override
    public Image getImageWithName(String name) {
        return null;
    }
}
