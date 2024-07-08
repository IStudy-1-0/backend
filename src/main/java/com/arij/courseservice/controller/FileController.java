package com.arij.courseservice.controller;
import com.arij.courseservice.entities.Fichier;
import com.arij.courseservice.entities.Image;
import com.arij.courseservice.services.CloudinaryService;
import com.arij.courseservice.services.FichierService;
import com.arij.courseservice.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

                    List<Fichier> fichiers = new ArrayList<>();
                    StringBuilder responseMessage = new StringBuilder();

                    for (MultipartFile multipartFile : multipartFiles) {
                        try {
                            if (multipartFile.getSize() > MAX_FILE_SIZE){
                                responseMessage.append("File ").append(multipartFile.getOriginalFilename()).append(" is too large. Maximum size allowed is 1GB.\n");
                                continue;
                            }

                            // Upload file to Cloudinary
                            Map result = cloudinaryService.upload(multipartFile);
                            Fichier fichier = new Fichier((String) result.get("original_filename"),
                                    (String) result.get("url"),
                                    (String) result.get("public_id"));
                            fichiers.add(fichier);
                        } catch (IOException e) {
                            responseMessage.append("Failed to upload file ").append(multipartFile.getOriginalFilename()).append(": ").append(e.getMessage()).append("\n");
                        }
                    }

                    try {
                        // Save files and link to course
                        fichierService.uploadFichierAndAffectToCourse(fichiers, idCourse);
                        responseMessage.append("All files processed successfully!");
                        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.OK);
                    } catch (IOException e) {
                        return new ResponseEntity<>("Failed to link files to course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }

    @DeleteMapping("/delete/{idFichier}")
    public ResponseEntity<String> delete(@PathVariable("idFichier") String idFichier) {
        Optional<Fichier> fichierOptional = fichierService.getOne(idFichier);
        if (fichierOptional.isEmpty()) {
            return new ResponseEntity<>("n'existe pas", HttpStatus.NOT_FOUND);
        }
        Fichier file = fichierOptional.get();
        String cloudinaryFileId = file.getId();
        try {
            cloudinaryService.delete(cloudinaryFileId);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to delete image from Cloudinary", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        fichierService.deleteFichierById(idFichier);
        return new ResponseEntity<>("image supprimée !", HttpStatus.OK);
    }

    }

