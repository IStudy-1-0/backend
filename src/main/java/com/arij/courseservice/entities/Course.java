package com.arij.courseservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private Long idUser;

   // @Enumerated(EnumType.STRING)
    //private LevelTypeCourse levelCourse;

    private String description;

    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @Enumerated(EnumType.STRING)
    private TopicType topic;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Video> videos;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Fichier> fichiers;

    @OneToOne (cascade = CascadeType.ALL)
    Image courseImage;

}

