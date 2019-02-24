package com.tpwls.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tpwls.dao.ReplyDAO;
import com.tpwls.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		dao.insertReply(vo);
	}

	@Override
	public List<ReplyVO> readReply(ReplyVO vo) throws Exception {
		return dao.readReply(vo);
	}

}
