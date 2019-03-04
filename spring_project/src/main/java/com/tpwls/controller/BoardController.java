package com.tpwls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tpwls.service.BoardService;
import com.tpwls.vo.BoardVO;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService service;

	// 모든 게시글을 읽음
	@RequestMapping(value = "/read.do", method = RequestMethod.GET)
	public List<BoardVO> readAllBoard() throws Exception {
		printLocation("모든 게시글을 읽음.");
		return service.readAllBoard();
	}

	// 게시글 생성
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public Map<String, String> insertBoard(@RequestBody BoardVO vo) throws Exception {
		printLocation("게시글 추가 : " + vo.getTitle());
		if (vo.getTitle().equals("") || vo.getWriter().equals(""))
			return null;
		Map<String, String> map = new HashMap<>();
		try {
			service.insertBoard(vo);
			map.put("code", "200"); // OK
		} catch (Exception e) {
			map.put("code", "400"); // BadRequest
		}
		return map;
	}

	// 게시글 하나를 읽는다.
	@RequestMapping(value = "/readBoard.do", method = RequestMethod.POST)
	public BoardVO readBoard(@RequestBody BoardVO vo) throws Exception {
		int bno = vo.getBno();
		printLocation("게시글을 일는다 -> " + bno + "번");
		return service.readBoard(bno);
	}

	// 게시글 조회수 1 증가
	@RequestMapping(value = "upViewCount.do", method = RequestMethod.POST)
	public Map<String, String> upViewCount(@RequestBody BoardVO vo) {
		int bno = vo.getBno();
		printLocation(bno + "번 조회수를 1 증가");
		Map<String, String> map = new HashMap<>();
		try {
			service.upViewCount(bno);
			map.put("code", "200"); // OK
		} catch (Exception e) {
			map.put("code", "400"); // BadRequest
		}
		return map;
	}

	private void printLocation(String content) {
		System.out.print(this.getClass().getSimpleName() + " => ");
		System.out.println(content);
	}

}
