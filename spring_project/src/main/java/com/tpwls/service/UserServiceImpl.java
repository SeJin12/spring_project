package com.tpwls.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tpwls.dao.UserDAO;
import com.tpwls.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	@Override
	public UserVO checkLogin(String uemail, String upw) throws Exception {
		return dao.checkLogin(uemail, upw);	
	}

	@Override
	public List<UserVO> readAllUser() throws Exception {
		return dao.readAllUser();
	}

	@Override
	public void insertUser(UserVO vo) throws Exception {
		dao.insertUser(vo);
	}

	@Override
	public UserVO readUser(String uemail) throws Exception {
		return dao.readUser(uemail);
	}

}
