package com.arij.courseservice.util;

import lombok.experimental.UtilityClass;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class ImageUploadUtil {
    public static final long MAX_FILE_SIZE = 3 * 1024 * 1024;
    public static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png))$)";
    public static final String FILE_NAME_FORMAT = "%s_%s";
    public static boolean isALLowedExtension (final String fileName, final String pattern){
        final Matcher matcher = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE).matcher(fileName);
        return matcher.matches();
    }

    public static void assertAllowed(MultipartFile file, String pattern){
        final long size = file.getSize();
        if (size > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("L'image est de taille maximale 3MB");
        }
        final String fileName = file.getOriginalFilename();
        if (! isALLowedExtension(fileName, pattern)){
            throw new IllegalArgumentException(" seulement l'extension png et jpg sont acceptées");
        }
    }

    public static String getFileName(final String name){
        return String.format(FILE_NAME_FORMAT, name);
    }

}
