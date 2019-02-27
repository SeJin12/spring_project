package com.tpwls.controller;


import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadForm(MultipartFile file) throws Exception { //FIXME User Name을 매개변수로 받아 구분
		System.out.println(this.getClass().getName());
		System.out.println("originalName: "+file.getOriginalFilename());
		System.out.println("size: "+file.getSize());
		System.out.println("contentType: "+file.getContentType());
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		return savedName;
	}
	
	private String uploadFile(String originalName,byte[] fileData) throws Exception {
		UUID uid =  UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
}
