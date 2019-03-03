package com.tpwls.dao;

import java.util.List;

import com.tpwls.vo.UserVO;

public interface UserDAO {
	
	public List<UserVO> readAllUser()throws Exception;
	
	public void insertUser(UserVO vo);
	
	public UserVO readUser(String uemail)throws Exception;
	
	public UserVO checkLogin(String uemail,String upw)throws Exception;
	
	public void updatePath(UserVO vo);
}
