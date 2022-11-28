package com.atguigu.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloadUtil {

    public static ResponseEntity<byte[]> putFile(String realPath) throws IOException {
        //获取ServletContext对象
        //获取服务器中文件的真实路径
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组，is.available()获取输入流所对应文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        String randomAlphabetic = RandomStringUtils.randomAlphabetic(15);
        headers.add("Content-Disposition", "attachment;filename="+randomAlphabetic+".jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }


}
