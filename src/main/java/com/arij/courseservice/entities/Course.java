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
    private String titleCourse;
    @Enumerated(EnumType.STRING)
    private LevelTypeCourse levelCourse;
    private String description;
    private LocalDate creationDate;
    private LocalDate updatingDate;
    private int learningLevel;

    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @Enumerated(EnumType.STRING)
    private TopicType topic;

    @OneToMany(mappedBy = "course")
    private List<Seance> seances;

    @OneToOne(mappedBy = "course")
    private Progression progression;

    @ManyToOne
    private User user;
}

