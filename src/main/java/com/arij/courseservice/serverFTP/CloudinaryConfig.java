package com.arij.courseservice.serverFTP;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    private final String CLOUD_NAME="arij.hakouna";
    private final String API_KEY="288163577766182";
    private final String API_SECRET="2sMbGlrjgleft9QyIHuROScIrJM";

    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret",API_SECRET);
        return new Cloudinary(config);
    }
}
