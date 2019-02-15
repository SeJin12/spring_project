package com.tpwls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tpwls.service.UserService;
import com.tpwls.vo.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;

	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public Map<String, String> test() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1��", "����");
		map.put("2��", "����");
		return map;
	}
	
	@RequestMapping(value="/checkEmail.do", method=RequestMethod.POST)
	public UserVO checkEmail(@RequestBody UserVO vo) throws Exception {
		String uemail = vo.getUemail();
		printLocation("�̸��� �ߺ� Ȯ�� ��û : uemail="+uemail);
		return service.readUser(uemail);
	}
	
	@RequestMapping(value = "/read.do", method = RequestMethod.GET)
	public List<UserVO> readAllUser() throws Exception {
		printLocation("��� ������ ������ ����");
		return service.readAllUser();
	}

	// uemail, upw, uname, uphone, uregion
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public Map<String, String> insert(@RequestBody UserVO vo) throws Exception {

		printLocation("���� �߰��� email -> "+vo.getUemail());
		System.out.println(vo.getUregion());
		if(!(!vo.getUemail().equals("")&&!vo.getUpw().equals("")&&!vo.getUname().equals("")
				&&!vo.getUphone().equals("")&&!vo.getUregion().equals("")))
			return null;

		Map<String, String> map = new HashMap<>();
		try {
			service.insertUser(vo);
			map.put("code", "200"); // OK
		} catch (Exception e) {
			map.put("code", "400"); // BadRequest
		}
		return map;
	}

	// ��ȸ ����/���н� 200 Response, ����Ͽ��� �α��� �� Json ��ü ������ Ȯ�� �� �α���
	@RequestMapping(value = "/check.do", method = RequestMethod.POST)
	public UserVO checkLogin(@RequestBody UserVO vo) throws Exception {
		String uemail = vo.getUemail();
		String upw = vo.getUpw();
		printLocation("�α��� Ȯ�� ��û : uemail="+uemail + ", upw=" + upw);

		return service.checkLogin(uemail, upw);
	}
	
	private void printLocation(String content) {
		System.out.print(this.getClass().getSimpleName()+" => ");
		System.out.println(content);
	}
}
