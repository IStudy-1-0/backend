package com.arij.courseservice.configCloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dx9hxkli4");
        config.put("api_key", "288163577766182");
        config.put("api_secret", "2sMbGlrjgleft9QyIHuROScIrJM");
        return new Cloudinary(config);
    }
}
