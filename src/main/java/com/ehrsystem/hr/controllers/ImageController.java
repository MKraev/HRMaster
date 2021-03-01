package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.services.ImageService;
import com.ehrsystem.hr.services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class ImageController {

    private final ImageService imageService;
    private final UserService userService;

    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @GetMapping("user/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("user", userService.findCommandById(Long.valueOf(id)));

        return "user/imageuploadform";
    }

    @PostMapping("user/{id}/image")
    public String handleImagePost(Model model,@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);

        User user = userService.findById(Long.valueOf(id));

        model.addAttribute("user", user);

        return "user/showuser";
    }

    @GetMapping("user/{id}/userimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        User userCommand = userService.findById(Long.valueOf(id));


        if (userCommand.getImage() != null) {
            byte[] byteArray = new byte[userCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : userCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
