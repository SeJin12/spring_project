package com.tpwls.service;

import java.util.List;

import com.tpwls.vo.UserVO;

public interface UserService {
	
	public void insertUser(UserVO vo) throws Exception;
	
	public UserVO readUser(String uemail) throws Exception;
	
	public UserVO checkLogin(String uemail,String upw) throws Exception;
	
	public List<UserVO> readAllUser() throws Exception;
}
