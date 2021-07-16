package com.hzy.file.controller;

import com.hzy.file.controller.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    public static final String FILE_PATH = "F:\\upload\\";

    @PostMapping(value = "/testFile")
    @ResponseBody
    public String testFile(@RequestPart("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        System.out.println("++++++++" + fileName + "+++++++");
        String originalFilename = file.getOriginalFilename();
        String fileAllPath = FILE_PATH + System.currentTimeMillis() + originalFilename;
        File upload = new File(fileAllPath);
        try {
            file.transferTo(upload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @PostMapping(value = "/test")
    @ResponseBody
    public String test(String fileName) {
        System.out.println("++++++++" + fileName + "+++++++");
        return "success";
    }

}
