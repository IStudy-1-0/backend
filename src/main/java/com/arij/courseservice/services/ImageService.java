package com.arij.courseservice.services;

import com.arij.courseservice.entities.Course;
import com.arij.courseservice.entities.Image;
import com.arij.courseservice.repository.ICourseRepo;
import com.arij.courseservice.repository.IImageRepo;
import com.arij.courseservice.services.interfaces.IImageService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ImageService implements IImageService {

    private final IImageRepo imageRepository;
    ICourseRepo courseRepo;

    @Override
    public Image uploadImageAndAffectToCourse(Image image, Long idCourse) throws IOException {
        Image img = imageRepository.save(image);
        Course course = courseRepo.findCourseById(idCourse);
        course.setCourseImage(img);
        courseRepo.save(course);
        return course.getCourseImage();
    }
    @Transactional
    @Override
    public void deleteImageById(String idImage) {
     imageRepository.deleteImageById(idImage);
    }
    @Override
    public Optional<Image> getOne(String idImage){
        return imageRepository.findById(idImage);
    }
}
