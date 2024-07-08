package com.arij.courseservice.services;

import com.arij.courseservice.entities.Course;
import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.entities.Image;
import com.arij.courseservice.repository.ICourseRepo;
import com.arij.courseservice.repository.IFichierRepo;
import com.arij.courseservice.repository.IImageRepo;
import com.arij.courseservice.services.interfaces.IFichierService;
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
public class FichierService implements IFichierService {

    private final IFichierRepo fichierRepo;
    ICourseRepo courseRepo;


    @Override
    public List<Fichier> uploadFichierAndAffectToCourse(List<Fichier> fichiers, Long idCourse) throws IOException {
        // Sauvegarde chaque fichier dans le dépôt
        List<Fichier> savedFichiers = new ArrayList<>();

        for (Fichier fichier : fichiers) {
            savedFichiers.add(fichierRepo.save(fichier));
        }

        // Récupère le cours par son ID
        Course course = courseRepo.findCourseById(idCourse);
        if (course == null) {
            throw new IOException("Cours non trouvé pour l'ID: " + idCourse);
        }

        // Ajoute les fichiers au cours et sauvegarde le cours mis à jour
        List<Fichier> fichierList = course.getFichiers();
        if (fichierList == null) {
            fichierList = new ArrayList<>();
        }
        fichierList.addAll(savedFichiers);
        course.setFichiers(fichierList);
        courseRepo.save(course);

        return course.getFichiers();

    }

    @Override
    public Optional<Fichier> getOne(String idFichier) {
        return Optional.empty();
    }

    @Override
    public void deleteFichierById(String idFichier) {

    }
}
