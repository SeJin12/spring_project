package com.tpwls.controller;


import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tpwls.service.UserService;
import com.tpwls.vo.UserVO;

@RestController
@RequestMapping("/image")
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private UserService service;
	
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public int uploadForm(MultipartFile uploadFile,String email) throws Exception { //FIXME User Name을 매개변수로 받아 구분
		System.out.println("image upload Email : " + email);
		System.out.println(this.getClass().getName());
		
		String savedName = uploadFile(uploadFile.getOriginalFilename(), uploadFile.getBytes());
		
		System.out.println(uploadPath);
		
		String absolutePath = uploadPath.replace("\\\\", "\\") + "\\" + savedName;
		System.out.println(absolutePath);
		
		if(savedName==null || !updatePath(absolutePath, email))
			return 400;
		
		return 200;
	}
	
	private boolean updatePath(String path,String email) {
		UserVO vo = new UserVO();
		vo.setUemail(email);
		vo.setImagepath(path);
		try {
			service.updatePath(vo);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	private String uploadFile(String originalName,byte[] fileData) throws Exception {
		UUID uid =  UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
}
