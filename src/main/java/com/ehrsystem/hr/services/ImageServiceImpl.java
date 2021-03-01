package com.ehrsystem.hr.services;

import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final UserRepository userRepository;

    public ImageServiceImpl( UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long userId, MultipartFile file) {

        try {
            User user = userRepository.findById(userId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            user.setImage(byteObjects);

            userRepository.save(user);
        } catch (IOException e) {

            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
