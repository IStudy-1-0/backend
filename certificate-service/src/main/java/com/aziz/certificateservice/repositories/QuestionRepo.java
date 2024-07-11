package com.aziz.certificateservice.repositories;

import com.aziz.certificateservice.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
