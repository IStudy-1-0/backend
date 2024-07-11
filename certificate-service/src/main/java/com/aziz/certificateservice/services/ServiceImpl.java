package com.aziz.certificateservice.services;

import com.aziz.certificateservice.dto.AnswerDTO;
import com.aziz.certificateservice.dto.QuestionDTO;
import com.aziz.certificateservice.models.Answer;
import com.aziz.certificateservice.models.Certificat;
import com.aziz.certificateservice.models.Question;
import com.aziz.certificateservice.models.Quiz;
import com.aziz.certificateservice.repositories.AnswerRepo;
import com.aziz.certificateservice.repositories.CertificatRepo;
import com.aziz.certificateservice.repositories.QuestionRepo;
import com.aziz.certificateservice.repositories.QuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class ServiceImpl implements IService {
    CertificatRepo certificatRepo;
    AnswerRepo answerRepo;
    QuestionRepo questionRepo;
    QuizRepo quizRepo;


    @Override
    public Certificat ajouterCertificat(Certificat certificat) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();
        certificat.setCreatedBy(jwt.getClaimAsString("sub"));
        return certificatRepo.save(certificat);
    }

    @Override
    public List<Certificat> getCertficats() {
        return (List<Certificat>) certificatRepo.findAll();
    }

    @Override
    public List<Quiz> getQuizzs() {
        return quizRepo.findAll();
    }

    @Override
    public Quiz ajouterQuiz(String titre, String description, List<QuestionDTO> questionsDTO) {
        Quiz quiz = new Quiz();
        quiz.setTitre(titre);
        quiz.setDescription(description);

        List<Question> questions = new ArrayList<>();

        for (QuestionDTO questionDTO : questionsDTO) {
            Question question = new Question();
            question.setLabel(questionDTO.getLabel());

            List<Answer> answers = new ArrayList<>();

            for (AnswerDTO answerDTO : questionDTO.getResponses()) {
                Answer answer = new Answer();
                answer.setLabel(answerDTO.getLabel());
                answer.setCorrect(answerDTO.isCorrect());
                answer.setQuestion(question);

                answers.add(answer);
            }

            question.setAnswers(answers);
            question.setQuiz(quiz);

            questions.add(question);
        }

        quiz.setQuestions(questions);

        return quizRepo.save(quiz);
    }


    @Override
    public Certificat supprimerCertificat(Certificat certificat) {
        certificatRepo.delete(certificat);
        return certificat;
    }


//    @Override
//    public Quiz affecterCertificat(Long quizId, Long certificatId) {
//        Quiz quiz = quizRepo.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
//        Certificat certificat = certificatRepo.findById(certificatId).orElseThrow(() -> new RuntimeException("Certificat non trouvé"));
//
//        quiz.setCertificat(certificat);
//
//        return quizRepo.save(quiz);
//    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepo.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id " + quizId));
    }

    public Map<String, Object> calculerScoreEtMessage(Long quizId, Map<Long, Long> userResponses) {
        Quiz quiz = quizRepo.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));

        int totalQuestions = quiz.getQuestions().size();
        int correctAnswers = 0;

        for (Question question : quiz.getQuestions()) {
            Long questionId = question.getId();
            Long userResponseId = userResponses.get(questionId);

            if (userResponseId != null) {
                for (Answer answer : question.getAnswers()) {
                    if (answer.isCorrect() && answer.getId().equals(userResponseId)) {
                        correctAnswers++;
                        break;
                    }
                }
            }
        }

        double scorePercentage = (double) correctAnswers / totalQuestions * 100.0;

        Map<String, Object> response = new HashMap<>();
        response.put("score", scorePercentage);

        if (scorePercentage >= 75) {
            Certificat certificat = quiz.getCertificat();
            if (certificat != null) {
                response.put("message", "Félicitations, vous avez obtenu votre certificat !");
                response.put("certificatTitre", certificat.getTitle());
            }
        }

        return response;
    }
}
