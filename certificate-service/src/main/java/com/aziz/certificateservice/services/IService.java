package com.aziz.certificateservice.services;

import com.aziz.certificateservice.dto.QuestionDTO;
import com.aziz.certificateservice.models.Certificat;
import com.aziz.certificateservice.models.Quiz;

import java.util.List;
import java.util.Map;

public interface IService {
    public Certificat ajouterCertificat (Certificat certificat);



    List<Certificat> getCertficats();



    public Quiz ajouterQuiz(String titre, String description, List<QuestionDTO> questionsDTO);


    public Certificat supprimerCertificat (Certificat certificat);

    Map<String, Object> calculerScoreEtMessage(Long quizId, Map<Long, Long> userResponses);
//    public Quiz affecterCertificat(Long quizId, Long certificatId);

    public Quiz getQuizById(Long quizId);

    public List<Quiz> getQuizzs();
}
