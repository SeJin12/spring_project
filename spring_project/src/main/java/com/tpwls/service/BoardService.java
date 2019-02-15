package com.tpwls.service;

import java.util.List;

import com.tpwls.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> readAllBoard() throws Exception;

	public void insertBoard(BoardVO vo) throws Exception;

	public BoardVO readBoard(int bno) throws Exception;

	public void upViewCount(int bno) throws Exception;
}
