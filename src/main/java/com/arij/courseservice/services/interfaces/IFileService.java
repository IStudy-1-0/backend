package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFileService {

    String uploadAndSaveFile(MultipartFile multipartFile , String fileName) throws IOException;

    File deleteFile(File file);
    void deleteFileWithId(long id);
    void  deleteFileWithName(String name);
    File updateFile(File file);
    File updateFileWithName(String name);
    List<File> getListFile();
    File getFileWithName(String name);

}
