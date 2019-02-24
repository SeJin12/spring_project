package com.tpwls.vo;

public class ReplyVO {
	private int rno, bno;
	private String replytext, replyer, regdate, updatedate;

	public ReplyVO() {
		super();
	}

	public ReplyVO(int rno, int bno, String replytext, String replyer) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
	}

	public ReplyVO(int bno, String replytext, String replyer) {
		super();
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
	}

	public ReplyVO(int rno, int bno, String replytext, String replyer, String regdate, String updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

}
