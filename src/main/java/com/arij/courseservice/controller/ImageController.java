package com.arij.courseservice.controller;

import com.arij.courseservice.entities.Image;
import com.arij.courseservice.services.CloudinaryService;
import com.arij.courseservice.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RequestMapping(path = "/image-controller")
@AllArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;
    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload-image/{idCourse}")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestParam MultipartFile multipartFile, @PathVariable("idCourse") long idCourse) {
        try {
            BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
            if (bi == null) {
                return new ResponseEntity<>("Image non valide!", HttpStatus.BAD_REQUEST);
            }
            Map result = cloudinaryService.upload(multipartFile);
            Image image = new Image((String) result.get("original_filename"),
                    (String) result.get("url"),
                    (String) result.get("public_id"));
            imageService.uploadImageAndAffectToCourse(image, idCourse);
            return new ResponseEntity<>("Image ajoutée avec succès !", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idImage}")
    public ResponseEntity<String> delete(@PathVariable("idImage") String idImage) {
        Optional<Image> imageOptional = imageService.getOne(idImage);
        if (imageOptional.isEmpty()) {
            return new ResponseEntity<>("n'existe pas", HttpStatus.NOT_FOUND);
        }
        Image image = imageOptional.get();
        String cloudinaryImageId = image.getId();
        try {
            cloudinaryService.delete(cloudinaryImageId);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to delete image from Cloudinary", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        imageService.deleteImageById(idImage);
        return new ResponseEntity<>("image supprimée !", HttpStatus.OK);
    }



}
