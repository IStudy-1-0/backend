package com.aziz.certificateservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String titre;
    private int score;
    @Getter
    private String description;

    @Getter
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)

    private List<Question> questions ;


    @Getter
    @ManyToOne
    @JoinColumn(name = "certificat_id")

    private Certificat certificat; // Association avec un certificat existant
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setTitre(String titre) { this.titre = titre; }

    public void setDescription(String description) { this.description = description; }

    public void setQuestions(List<Question> questions) { this.questions = questions; }

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    }
    @Getter
    @Setter
    @Column(name = "created_by")
    private String createdBy;

    @Getter
    @Setter
    @Column(name = "passed_by")
    @ElementCollection
    private List<String> passedBy;

}
