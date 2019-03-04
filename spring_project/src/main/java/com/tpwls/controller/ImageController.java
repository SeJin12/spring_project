package com.tpwls.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tpwls.service.UserService;
import com.tpwls.utils.MediaUtils;
import com.tpwls.vo.UserVO;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private UserService service;

	// 이미지 파일 업로드
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public int uploadForm(MultipartFile uploadFile, String email) throws Exception { // FIXME User Name을 매개변수로 받아 구분
		System.out.println("image upload Email : " + email);
		System.out.println(this.getClass().getName());

		String savedName = uploadFile(uploadFile.getOriginalFilename(), uploadFile.getBytes());

		if (savedName == null || !updatePath(savedName, email))
			return 400;

		return 200;
	}

	// 웹에 이미지 출력
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(@RequestParam("email") String email) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		String fileName = null;
		try {
			fileName = service.readUser(email).getImagepath();
		} catch (NullPointerException e) {
			return null;
		}

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + "/" + fileName);

			// step: change HttpHeader ContentType
			if (mType != null) {
				// image file(show image)
				headers.setContentType(mType);
			} else {
				// another format file(download file)
				fileName = fileName.substring(fileName.indexOf("_") + 1);// original file Name
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;

	}

	// User imagePath 업데이트
	private boolean updatePath(String fileName, String email) {
		UserVO vo = new UserVO();
		vo.setUemail(email);
		vo.setImagepath(fileName);
		try {
			service.updatePath(vo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// Client에서 받아온 이미지 파일 서버에 생성
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);

		return savedName;
	}

}
