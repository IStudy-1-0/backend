package com.arij.courseservice.util;

import lombok.experimental.UtilityClass;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class FileUploadUtil {
    public static final long MAX_FILE_SIZE = 1048576000;
    public static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(pdf|doc|txt))$)";
    public static final String FILE_NAME_FORMAT = "%s_%s";
    public static boolean isALLowedExtension (final String fileName, final String pattern){
        final Matcher matcher = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE).matcher(fileName);
        return matcher.matches();
    }

    public static void assertAllowed(MultipartFile file, String pattern){
        final long size = file.getSize();
        if (size > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("Le fichier est de taille maximale 30MB");
        }
        final String fileName = file.getOriginalFilename();
        if (! isALLowedExtension(fileName, pattern)){
            throw new IllegalArgumentException(" seulement l'extension pdf, txt et doc sont acceptées");
        }
    }

    public static String getFileName(final String name){
        return String.format(FILE_NAME_FORMAT, name);
    }

}
