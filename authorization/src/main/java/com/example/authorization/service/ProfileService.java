package com.example.authorization.service;

import com.example.authorization.dto.AddProfileInfo;
import com.example.authorization.dto.ProfileDto;
import com.example.authorization.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ProfileService {

    void editProfile(AddProfileInfo addProfileInfo, MultipartFile avatar, MultipartFile cover) throws IOException;

    void createNewProfile(User user);

    ProfileDto getProfileInfoCurrentUser();

    ProfileDto getProfileInfo(Long userId);
}
