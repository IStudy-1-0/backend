package com.arij.courseservice.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IVideoService {
    MultipartFile uploadVideoAndAffectToCourse(MultipartFile Video, Long idCourse) throws  IOException;
    void  deleteVideoById(long idVideo );

}
