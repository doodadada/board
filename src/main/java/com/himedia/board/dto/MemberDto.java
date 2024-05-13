package com.himedia.board.dto;

public class MemberDto {
	private String userid;
	private String name;
	private String pwd;
	private String email;
	private String phone;

	public MemberDto() {
	}

	public MemberDto(String userid, String name, String pwd, String email, String phone) {
		this.userid = userid;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", phone="
				+ phone + "]";
	}

}
