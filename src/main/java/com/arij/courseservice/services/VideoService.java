package com.arij.courseservice.services;

import com.arij.courseservice.repository.IVideoRepo;
import com.arij.courseservice.services.interfaces.IVideoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
public class VideoService implements IVideoService {
    private final IVideoRepo videoRepository;
   // private final IFileUploadService fileUpload;

    @Override
    public MultipartFile uploadVideoAndAffectToCourse(MultipartFile Video, Long idCourse) throws IOException {
        return null;
    }

    @Override
    public void deleteVideoById(long idVideo) {

    }
}
