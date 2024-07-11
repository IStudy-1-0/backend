package com.aziz.certificateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCertificat;

    private String title;
    private String description;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private CertificationType certificationType;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @Column(name = "created_by")
    private String createdBy;

    // Méthode pour définir le titre du certificat
    public void setTitre(String titre) {
        this.title = titre;
    }

    // Méthode pour définir la description du certificat
    public void setDescription(String description) {
        this.description = description;
    }

}