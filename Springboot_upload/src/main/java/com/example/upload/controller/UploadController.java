package com.example.upload.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	  private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

	  @RequestMapping(value="/upload", method=RequestMethod.GET)  
	    public String upload() {
	    	System.out.println("-----------------------");
	        return "upload";
	    }

	    @PostMapping("/upload")
	    @ResponseBody
	    public String upload(@RequestParam("file") MultipartFile file) {
	        if (file.isEmpty()) {
	            return "上传失败，请选择文件";
	        }

	        String fileName = file.getOriginalFilename();
	        String filePath = "E:/";
	        File dest = new File(filePath + fileName);
	        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
	            dest.getParentFile().mkdir();
	        }
	        System.out.println("---------------------------------------");
	        try {
	            file.transferTo(dest);
	            LOGGER.info("上传成功");
	            return "上传成功";
	        } catch (IOException e) {
	            LOGGER.error(e.toString(), e);
	        }
	        return "上传失败！";
	    }
	
}
