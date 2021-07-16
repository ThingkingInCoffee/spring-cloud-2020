package com.hzy.form.feign;

import com.hzy.form.feign.impl.FileServiceImpl;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        value = "cloud-file-upload-service",
        fallback = FileServiceImpl.class,
        configuration = {FileService.MultipartSupportConfig.class}
)
public interface FileService {

//    @GetMapping("/uploadFileByUrl")
//    @ApiImplicitParams(value = {@ApiImplicitParam(name = "url", value = "url地址", required = true),
//            @ApiImplicitParam(name = "filePathPrefix", value = "url路径前缀", required = true)}
//    )
//    APiResponse<ImgVO> uploadFileByUrl(@RequestParam(name = "url") String url, @RequestParam("filePathPrefix") String filePathPrefix);
//
//    @PostMapping(value = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    APiResponse<String> uploadFile(@RequestPart(value = "file", required = true) MultipartFile file,
//                                   @RequestParam(name = "filePathPrefix") String filePathPrefix);

    @PostMapping(value = "/upload/testFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String testFile(@RequestPart(value = "file") MultipartFile file, @RequestParam("fileName") String fileName);

    @PostMapping(value = "/upload/test")
    String test(String fileName);

    @Configuration
    class MultipartSupportConfig {

        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        /**
         * feign上传文件 处理
         *
         * @return
         */
        @Bean
        @Primary
        @Scope("prototype")
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

        /**
         * feign下载多个文件返回处理
         * @return
         */
//        @Bean
//        public Decoder feignDecoder() {
//            List<HttpMessageConverter<?>> springConverters =
//                    messageConverters.getObject().getConverters();
//
//            List<HttpMessageConverter<?>> decoderConverters =
//                    new ArrayList<>(springConverters.size() + 1);
//
//            decoderConverters.addAll(springConverters);
//            decoderConverters.add(new SpringManyMultipartFilesReader(4096));
//
//            HttpMessageConverters httpMessageConverters = new HttpMessageConverters(decoderConverters);
//
//            return new SpringDecoder(new ObjectFactory<HttpMessageConverters>() {
//                @Override
//                public HttpMessageConverters getObject() {
//                    return httpMessageConverters;
//                }
//            });
//        }
    }

}
