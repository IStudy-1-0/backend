package com.arij.courseservice.services;

import com.arij.courseservice.entities.File;
import com.arij.courseservice.repository.IFileRepo;
import com.arij.courseservice.services.interfaces.IFileService;
import com.arij.courseservice.services.interfaces.IFileUploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
public class FileService implements IFileService {

    private final IFileRepo fileRepository;
    private final IFileUploadService fileUpload;



    @Override
    public String uploadAndSaveFile(MultipartFile multipartFile, String fileName) throws IOException {
        String fileURL = fileUpload.uploadFile(multipartFile);
        File file = new File();
        file.setUrl(fileURL);
        file.setName(multipartFile.getOriginalFilename());
        fileRepository.save(file);
        return fileURL;
    }



    @Override
    public File deleteFile(File file) {
        return null;
    }

    @Override
    public void deleteFileWithId(long id) {

    }

    @Override
    public void deleteFileWithName(String name) {

    }

    @Override
    public File updateFile(File file) {
        return null;
    }

    @Override
    public File updateFileWithName(String name) {
        return null;
    }

    @Override
    public List<File> getListFile() {
        return null;
    }

    @Override
    public File getFileWithName(String name) {
        return null;
    }
}
