package com.arij.courseservice.controller;
import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.services.CloudinaryService;
import com.arij.courseservice.services.FichierService;
import com.arij.courseservice.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.arij.courseservice.util.FileUploadUtil.MAX_FILE_SIZE;

@RequestMapping(path = "/file-controller")
@AllArgsConstructor
@RestController
public class FileController {
    private final FichierService fichierService;
    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload-fichiers/{idCourse}")
    @ResponseBody
    public ResponseEntity<String> uploadFichiers(@RequestParam List<MultipartFile> multipartFiles, @PathVariable("idCourse") long idCourse) {
        try {
            List<Fichier> fichiers = new ArrayList<>();
            for (MultipartFile multipartFile : multipartFiles) {
                if (multipartFile.getSize() > MAX_FILE_SIZE) {  // MAX_FILE_SIZE est une constante définie pour la taille maximale du fichier
                    return new ResponseEntity<>("Fichier trop volumineux", HttpStatus.BAD_REQUEST);
                }
                Fichier fichier = new Fichier();
                fichier.setName(multipartFile.getOriginalFilename());
                fichier.setContenu(multipartFile.getBytes());
                fichiers.add(fichier);
            }

            fichierService.uploadFichierAndAffectToCourse(fichiers, idCourse);
            return new ResponseEntity<>("Fichiers ajoutés avec succès !", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Erreur lors de l'ajout des fichiers: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
