package com.atguigu.controller;


import com.atguigu.utils.FileDownloadUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class FileAndDownController {

    @RequestMapping("/test/up")
    public String testUpPhoto(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件名
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //获取上传的文件的后缀名
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        //获取uuid
        String uuid = UUID.randomUUID().toString();
        //拼接一个新的文件名
        fileName = uuid + hzName;
        //获取servlet上下文对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程下的photo目录的真实路径
        String photoPath = servletContext.getRealPath("photo");
        //创建文件对象
        File file=new File(photoPath);
        //判断目录是否存在,如果不存在则创建一个新的
         if (!file.exists()){
             file.mkdir();
         }
         //获取最终上传的文件完整路径
        String finalPath = photoPath + File.separator + fileName;
         //上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "1.jpg";
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组，is.available()获取输入流所对应文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

}
