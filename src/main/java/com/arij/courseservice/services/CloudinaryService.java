package com.arij.courseservice.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service

public class CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result;
        try {
             result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            log.info("Upload result: " + result);
        } catch (Exception e) {
            log.error("Error uploading to Cloudinary: " + e.getMessage());
            throw new IOException("Failed to upload file to Cloudinary", e);
        } finally {
            if (!Files.deleteIfExists(file.toPath())) {
                log.error("Failed to delete temporary file: " + file.getAbsolutePath());
            }
        }
        return result;
    }

    public Map delete(String id) throws IOException {
        try {
            return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        } catch (Exception e) {
            log.error("Error deleting from Cloudinary: " + e.getMessage());
            throw new IOException("Failed to delete file from Cloudinary", e);
        }
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
