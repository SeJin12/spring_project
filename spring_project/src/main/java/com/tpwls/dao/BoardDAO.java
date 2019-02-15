package com.tpwls.dao;

import java.util.List;

import com.tpwls.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> readAllBoard() throws Exception;

	public void insertBoard(BoardVO vo);

	public BoardVO readBoard(int bno) throws Exception;

	public void upViewCount(int bno) throws Exception;

}
