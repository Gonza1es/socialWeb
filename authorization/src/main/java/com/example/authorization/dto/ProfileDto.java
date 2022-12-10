package com.example.authorization.dto;

import com.example.authorization.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class ProfileDto {

    private String aliasProfile;
    private String status;
    private Long avatarId;
    private Long coverId;

    private int subscribersCount;

    private List<Post> posts;
}
