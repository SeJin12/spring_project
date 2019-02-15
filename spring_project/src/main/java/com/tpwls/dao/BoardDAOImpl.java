package com.tpwls.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpwls.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.tpwls.mapper.boardMapper";
	
	@Override
	public List<BoardVO> readAllBoard() throws Exception {
		return sqlSession.selectList(namespace+".readAllBoard");
	}

	@Override
	public void insertBoard(BoardVO vo) {
		sqlSession.insert(namespace+".insertBoard",vo);	
	}

	@Override
	public BoardVO readBoard(int bno) throws Exception {
		return (BoardVO)sqlSession.selectOne(namespace+".readBoard",bno);
	}

	@Override
	public void upViewCount(int bno) throws Exception {
		sqlSession.insert(namespace+".upViewCount",bno);	
	}

}
