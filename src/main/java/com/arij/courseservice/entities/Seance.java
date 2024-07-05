package com.arij.courseservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleSeance;
    private boolean validateSeance;

    @ManyToOne
    @JoinColumn(name = "id_Course")
    private Course course;

    @OneToMany(mappedBy = "seance")
    private List<Video> videos;

    @ManyToOne
    private Seance seance;

    @OneToMany(mappedBy = "seance")
    private List<Image> images;

    @OneToMany(mappedBy = "seance")
    private List<File> files;
}
