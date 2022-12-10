package com.example.authorization.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageBytes;

    @OneToOne(mappedBy = "cover")
    private Profile profile;
}
