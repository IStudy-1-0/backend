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


}
