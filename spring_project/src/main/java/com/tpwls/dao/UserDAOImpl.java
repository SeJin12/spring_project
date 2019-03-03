package com.tpwls.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpwls.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.tpwls.mapper.userMapper";

	@Override
	public List<UserVO> readAllUser() throws Exception {
		return sqlSession.selectList(namespace + ".readAllUser");
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace + ".insertUser", vo);
	}

	@Override
	public UserVO readUser(String uemail) throws Exception {
		return (UserVO) sqlSession.selectOne(namespace + ".readUser", uemail);
	}

	@Override
	public UserVO checkLogin(String uemail, String upw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uemail", uemail);
		paramMap.put("upw", upw);
		return sqlSession.selectOne(namespace + ".checkLogin", paramMap);
	}

	@Override
	public void updatePath(UserVO vo) {
		sqlSession.update(namespace + ".updatePath", vo);
	}

}
