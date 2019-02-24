package com.tpwls.service;

import java.util.List;

import com.tpwls.vo.ReplyVO;

public interface ReplyService {
	
	public void insertReply(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> readReply(ReplyVO vo) throws Exception;

}
