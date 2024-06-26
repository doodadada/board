package com.himedia.board.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String pass;
	private String userid;
	private String email;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	private int replycnt;
	private String image;
	private String savefilename;
	
	
	public BoardDto() {
	}
	
	public BoardDto( String userid, String pass,  String email, String title, String content) {
		this.userid = userid;
		this.pass = pass;
		this.email = email;
		this.title = title;
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSavefilename() {
		return savefilename;
	}

	public void setSavefilename(String savefilename) {
		this.savefilename = savefilename;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", pass=" + pass + ", userid=" + userid + ", email=" + email + ", title="
				+ title + ", content=" + content + ", readcount=" + readcount + ", writedate=" + writedate
				+ ", replycnt=" + replycnt + ", image=" + image + ", savefilename=" + savefilename + "]";
	}

	

	
	
	
	
}
