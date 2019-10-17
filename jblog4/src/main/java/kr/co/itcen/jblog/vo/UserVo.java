package kr.co.itcen.jblog.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {

	@NotEmpty
	private String id; // 회원 아이디

	@NotEmpty
	@Length(min = 2, max = 10)
	private String name; // 회원 이름
	
	private String password; // 비밀번호
	private String reg_date; // 가입일

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

}
