package com.arij.courseservice.services;

import com.arij.courseservice.entities.Video;
import com.arij.courseservice.repository.IVideoRepo;
import com.arij.courseservice.services.interfaces.IFileUploadService;
import com.arij.courseservice.services.interfaces.IVideoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class VideoService implements IVideoService {
    private final IVideoRepo videoRepository;
    private final IFileUploadService fileUpload;
    @Override
    public String uploadAndSaveVideo(MultipartFile multipartFile) throws IOException {
        String videoURL = fileUpload.uploadFile(multipartFile);
        Video video = new Video();
        video.setUrl(videoURL);
        video.setName(multipartFile.getOriginalFilename());
        videoRepository.save(video);
        return videoURL;
    }

    @Override
    public Video deleteVideo(Video video) {
        return null;
    }

    @Override
    public void deleteVideoWithId(long id) {

    }

    @Override
    public void deleteVideoWithName(String name) {

    }

    @Override
    public Video updateVideo(Video video) {
        return null;
    }

    @Override
    public Video updateVideoWithName(String name) {
        return null;
    }

    @Override
    public List<Video> getListVideo() {
        return null;
    }

    @Override
    public Video getVideoWithName(String name) {
        return null;
    }
}
