package com.arij.courseservice.services;


import com.arij.courseservice.services.interfaces.IFileUploadService;
import com.arij.courseservice.util.ImageUploadUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import com.cloudinary.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class FileUploadService implements IFileUploadService {
    @Autowired
    private final Cloudinary cloudinary;


    @Override
    public String uploadFile(MultipartFile multipartFile, String fileName) throws IOException {
        ImageUploadUtil.assertAllowed(multipartFile ,ImageUploadUtil.IMAGE_PATTERN );
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", fileName))
                .get("url")
                .toString();
    }

}
