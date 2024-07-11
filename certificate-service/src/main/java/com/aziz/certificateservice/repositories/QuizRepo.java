package com.aziz.certificateservice.repositories;

import com.aziz.certificateservice.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Long> {
}
