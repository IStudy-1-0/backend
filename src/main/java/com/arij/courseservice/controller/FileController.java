package com.arij.courseservice.controller;
import org.springframework.ui.Model;
import com.arij.courseservice.entities.File;
import com.arij.courseservice.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping(path = "/file-controller")
@AllArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

   // @RequestMapping(path = "/file-controller")

    public String home(){
        return "home";
    }
    @GetMapping("/uploadFile")
    public String showUploadForm(Model model) {
        model.addAttribute("title", "Upload File");
        model.addAttribute("uploadAction", "/uploadFile");
        return "upload_form";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        String fileURL = fileService.uploadAndSaveFile(multipartFile);
        model.addAttribute("title", "File Seance");
        model.addAttribute("fileType", "file");
        model.addAttribute("fileURL", fileURL);
        return "seance";
    }
}
