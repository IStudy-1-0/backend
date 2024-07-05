package com.arij.courseservice.services;

import com.arij.courseservice.entities.Seance;
import com.arij.courseservice.services.interfaces.ISeanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class SeanceService implements ISeanceService {
    @Override
    public Seance assignFileToSeancet() {
        return null;
    }
}
