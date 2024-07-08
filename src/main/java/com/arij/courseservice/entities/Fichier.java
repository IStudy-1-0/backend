package com.arij.courseservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fichier {
    @Id
    private String id;
    private String url;
    private String name;
    @Lob
    private byte[] contenu;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;



    public Fichier(String name, String url, String id) {
        this.name = name;
        this.url = url;
        this.id = id;
    }
}
