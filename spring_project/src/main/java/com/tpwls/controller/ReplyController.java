package com.tpwls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tpwls.service.ReplyService;
import com.tpwls.vo.ReplyVO;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyService service;

	// 댓글 추가
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<String, String> insertReply(@RequestBody ReplyVO vo) throws Exception {
		printLocation("댓글 추가 : " + vo.getBno() + "번의 글");

		Map<String, String> map = new HashMap<>();
		try {
			service.insertReply(vo);
			map.put("code", "200"); // OK
		} catch (Exception e) {
			map.put("code", "400"); // BadRequest
		}
		return map;
	}

	// 하나의 게시글 읽음
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public List<ReplyVO> readReply(@RequestBody ReplyVO vo) throws Exception {
		printLocation(vo.getBno() + "번 글의 댓글을 읽는다.");
		return service.readReply(vo);
	}

	private void printLocation(String content) {
		System.out.print(this.getClass().getSimpleName() + " => ");
		System.out.println(content);
	}

}
