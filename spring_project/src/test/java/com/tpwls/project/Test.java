package com.tpwls.project;

import com.tpwls.vo.UserVO;

public class Test {
	

	
	String cName = this.getClass().getSimpleName();
	// »ç¶÷
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setUemail("tpwls@daum.net");
		vo.setUpw("secret");
		System.out.println(vo);
	}
}
