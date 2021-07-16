package com.hzy.form.feign.impl;

import com.hzy.form.feign.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: hezm
 * @Date: 2020/1/21 12:30
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String testFile(MultipartFile file, String fileName) {
        return "error";
    }

    @Override
    public String test(String fileName) {
        return "error";
    }

//    @Override
//    public APiResponse<ImgVO> uploadFileByUrl(String url, String filePathPrefix) {
//        log.error("上传文件{}错误",url);
//        return APiResponse.errorResp("上传文件失败");
//    }
//
//    @Override
//    public APiResponse<String> uploadFile(MultipartFile file, String filePathPrefix) {
//        return APiResponse.errorResp("上传文件失败");
//    }
}
