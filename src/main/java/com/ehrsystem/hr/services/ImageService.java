package com.ehrsystem.hr.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long userID, MultipartFile file);
}
