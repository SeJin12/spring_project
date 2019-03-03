package com.tpwls.vo;

public class UserVO {
//	private int unumber; // user number - auto increment value
	private String uemail, upw, uname, uphone, uregion;
	private String imagepath;
	

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUregion() {
		return uregion;
	}

	public void setUregion(String uregion) {
		this.uregion = uregion;
	}
	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "[UserVO]" + " email = " + uemail
				+ " pw = " + upw
				+ " name = " + uname
				+ " phone = " + uphone
				+ " region = " + uregion;
	}

	
}
