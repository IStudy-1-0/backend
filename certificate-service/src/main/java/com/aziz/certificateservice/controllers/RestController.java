package com.aziz.certificateservice.controllers;

import com.aziz.certificateservice.dto.QuestionDTO;
import com.aziz.certificateservice.models.Certificat;
import com.aziz.certificateservice.models.Quiz;
import com.aziz.certificateservice.services.IService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RestController {
    IService service;

    @PostMapping(path = "/ajoutcertificat")
    Certificat ajouterCertificat(@RequestBody Certificat certificat) {
        return service.ajouterCertificat(certificat);


    }

    @PostMapping("/ajouter")
    public ResponseEntity<Quiz> ajouterQuiz(
            @RequestParam String titre,
            @RequestParam String description,
            @RequestBody List<QuestionDTO> questionsDTO) {
        Quiz quiz = service.ajouterQuiz(titre, description, questionsDTO);
        return ResponseEntity.ok(quiz);
    }



    @GetMapping("/certificats")
    List<Certificat> getcertificats() {
        return service.getCertficats();
    }
    @GetMapping("/quizzs")
    List<Quiz> getquizzs() {return service.getQuizzs();}

    @DeleteMapping("/suppcertif")
    public Certificat supprimerCertificat(@RequestBody Certificat certificat) {
        return service.supprimerCertificat(certificat);
    }


    @PostMapping("/calculerScore")
    public ResponseEntity<Map<String, Object>> calculerScoreQuiz(@RequestBody Map<String, Object> payload) {
        Long quizId = ((Number) payload.get("quizId")).longValue();
        Map<Long, Long> userResponses = ((Map<String, Number>) payload.get("userResponses"))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> Long.valueOf(e.getKey()),
                        e -> e.getValue().longValue()
                ));

        Map<String, Object> result = service.calculerScoreEtMessage(quizId, userResponses);

        return ResponseEntity.ok(result);
    }
    @PostMapping("/{quizId}/certificat/{certificatId}")
    public ResponseEntity<Quiz> affecterCertificat(@PathVariable Long quizId, @PathVariable Long certificatId) {
        Quiz updatedQuiz = service.affecterCertificat(quizId, certificatId);
        return ResponseEntity.ok(updatedQuiz);
    }
    @GetMapping("/quizzs/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = service.getQuizById(quizId);
        return ResponseEntity.ok(quiz);
    }
}