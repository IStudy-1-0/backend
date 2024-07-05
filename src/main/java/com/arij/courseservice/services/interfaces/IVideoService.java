package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.File;
import com.arij.courseservice.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IVideoService {
    String uploadAndSaveVideo(MultipartFile multipartFile) throws IOException;    Video deleteVideo(Video video);
    void deleteVideoWithId(long id);
    void  deleteVideoWithName(String name);
    Video updateVideo(Video video);
    Video updateVideoWithName(String name);
    List<Video> getListVideo();
    Video getVideoWithName(String name);

}
