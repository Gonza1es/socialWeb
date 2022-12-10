package com.example.authorization.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Avatar {
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

    @OneToOne(mappedBy = "avatar")
    private Profile profile;

}
