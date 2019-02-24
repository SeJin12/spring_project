package com.tpwls.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpwls.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.tpwls.mapper.replyMapper";
	
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		sqlSession.insert(namespace+".insertReply",vo);
	}

	@Override
	public List<ReplyVO> readReply(ReplyVO vo) throws Exception {
		return sqlSession.selectList(namespace+".readReply",vo);
	}

}
