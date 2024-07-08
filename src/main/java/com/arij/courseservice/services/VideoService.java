package com.arij.courseservice.services;

import com.arij.courseservice.entities.Course;
import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.entities.Video;
import com.arij.courseservice.repository.ICourseRepo;
import com.arij.courseservice.repository.IVideoRepo;
import com.arij.courseservice.services.interfaces.IVideoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
public class VideoService implements IVideoService {
    private final IVideoRepo videoRepository;
    ICourseRepo courseRepo;

    @Override
    public List<Video> uploadVideoAndAffectToCourse(List<Video> videos, Long idCourse) throws IOException {
        // Sauvegarde chaque fichier dans le dépôt
        List<Video> savedVideos = new ArrayList<>();

        for (Video video : videos) {
            savedVideos.add(videoRepository.save(video));
        }

        // Récupère le cours par son ID
        Course course = courseRepo.findCourseById(idCourse);
        if (course == null) {
            throw new IOException("Cours non trouvé pour l'ID: " + idCourse);
        }

        // Ajoute les fichiers au cours et sauvegarde le cours mis à jour
        List<Video> videos1List = course.getVideos();
        if (videos1List == null) {
            videos1List = new ArrayList<>();
        }
        videos1List.addAll(savedVideos);
        course.setVideos(videos1List);
        courseRepo.save(course);

        return course.getVideos();

    }

    @Override
    public Optional<Video> getOne(String idVideo) {
        return videoRepository.findById(idVideo);
    }

    @Override
    @Transactional
    public void deleteVideoById(String idVideo) {
     videoRepository.deleteVideoById(idVideo);
    }
}
