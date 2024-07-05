package com.arij.courseservice.controller;

import com.arij.courseservice.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping(path = "/video-controller")
@AllArgsConstructor
@RestController
public class VideoContorller {
    private final VideoService videoService;

    @GetMapping("/uploadVideo")
    public String showUploadForm(Model model) {
        model.addAttribute("title", "Upload Video");
        model.addAttribute("uploadAction", "/uploadVideo");
        return "upload_form";
    }

    @PostMapping("/uploadVideo")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        String videoURL = videoService.uploadAndSaveVideo(multipartFile);
        model.addAttribute("title", "Video Seance");
        model.addAttribute("fileType", "video");
        model.addAttribute("fileURL", videoURL);
        return "seance";
    }

}
