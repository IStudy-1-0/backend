package com.arij.courseservice.controller;

import org.springframework.ui.Model;

import com.arij.courseservice.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping(path = "/image-controller")
@AllArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/uploadImage")
    public String showUploadForm(Model model) {
        model.addAttribute("title", "Upload Image");
        model.addAttribute("uploadAction", "/uploadImage");
        return "upload_form";
    }

    @PostMapping("/uploadImage")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        String imageURL = imageService.uploadAndSaveImage(multipartFile);
        model.addAttribute("title", "Image Seance");
        model.addAttribute("fileType", "image");
        model.addAttribute("fileURL", imageURL);
        return "seance";
    }
}
