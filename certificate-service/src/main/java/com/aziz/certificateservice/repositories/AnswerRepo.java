package com.aziz.certificateservice.repositories;

import com.aziz.certificateservice.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
}
