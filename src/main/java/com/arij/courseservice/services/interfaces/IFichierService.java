package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IFichierService {

    List<Fichier> uploadFichierAndAffectToCourse(List<Fichier> fichiers, Long idCourse) throws IOException;
    Optional<Fichier> getOne(String idFichier);
    void  deleteFichierById(String idFichier );

}
