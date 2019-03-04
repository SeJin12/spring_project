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

	// ��� �߰�
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<String, String> insertReply(@RequestBody ReplyVO vo) throws Exception {
		printLocation("��� �߰� : " + vo.getBno() + "���� ��");

		Map<String, String> map = new HashMap<>();
		try {
			service.insertReply(vo);
			map.put("code", "200"); // OK
		} catch (Exception e) {
			map.put("code", "400"); // BadRequest
		}
		return map;
	}

	// �ϳ��� �Խñ� ����
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public List<ReplyVO> readReply(@RequestBody ReplyVO vo) throws Exception {
		printLocation(vo.getBno() + "�� ���� ����� �д´�.");
		return service.readReply(vo);
	}

	private void printLocation(String content) {
		System.out.print(this.getClass().getSimpleName() + " => ");
		System.out.println(content);
	}

}
