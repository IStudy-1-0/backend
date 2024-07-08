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
public class Image {
    @Id
    private String id;
    private String url;
    private String name;


    @OneToOne (mappedBy = "courseImage",cascade = CascadeType.ALL)
    Course course;
    public Image(String name, String imageUrl, String imageId) {
        this.name = name;
        this.url = imageUrl;
        this.id = imageId;
    }

}
