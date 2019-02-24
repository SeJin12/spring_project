package com.tpwls.dao;

import java.util.List;

import com.tpwls.vo.ReplyVO;

public interface ReplyDAO {

	public void insertReply(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> readReply(ReplyVO vo) throws Exception;
	
}
