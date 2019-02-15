package com.tpwls.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tpwls.dao.BoardDAO;
import com.tpwls.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardVO> readAllBoard() throws Exception {
		return dao.readAllBoard();
	}

	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		dao.insertBoard(vo);
	}

	@Override
	public BoardVO readBoard(int bno) throws Exception {
		return dao.readBoard(bno);
	}

	@Override
	public void upViewCount(int bno) throws Exception {
		dao.upViewCount(bno);
	}

}
