package com.hzy.form.controller;

import com.hzy.form.feign.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feignUpload")
public class UploadFIleController {

    @Resource
    private FileService fileService;

    @PostMapping("/testFile")
    public String test(@RequestPart("file") MultipartFile file, @RequestParam("testName") String testName) {
        System.out.println("+++++++++++++++++++++" + file.getOriginalFilename());
        String s = null;
        s = fileService.testFile(file, testName);
        System.out.println("ssssssssss===" + s);
        return "feign success " + s;
    }

    @PostMapping(value = "/test")
    public String test(String fileName) {
        return fileService.test(fileName);
    }


}
