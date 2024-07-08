package com.arij.courseservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {
    @Id
    private String id;
    private String url;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Video(String name, String url, String id) {
        this.name = name;
        this.url = url;
        this.id = id;

    }
}
