package com.example.authorization.controller;

import com.example.authorization.model.Avatar;
import com.example.authorization.model.Cover;
import com.example.authorization.model.Image;
import com.example.authorization.repository.AvatarRepository;
import com.example.authorization.repository.CoverRepository;
import com.example.authorization.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/image")
public class ImageController {

    private final ImageRepository imageRepository;

    private final AvatarRepository avatarRepository;

    private final CoverRepository coverRepository;

    @GetMapping("/postImage/{id}")
    public ResponseEntity<?> getPostImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return  ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getImageBytes())));
    }

    @GetMapping("/avatar/{id}")
    public ResponseEntity<?> getAvatarById(@PathVariable Long id) {
        Avatar image = avatarRepository.findById(id).orElse(null);
        assert image != null;
        return  ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getImageBytes())));
    }

    @GetMapping("/cover/{id}")
    public ResponseEntity<?> getCoverById(@PathVariable Long id) {
        Cover image = coverRepository.findById(id).orElse(null);
        assert image != null;
        return  ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getImageBytes())));
    }
}
