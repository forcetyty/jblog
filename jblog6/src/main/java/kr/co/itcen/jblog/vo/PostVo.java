package kr.co.itcen.jblog.vo;

public class PostVo {

	private Long post_no;
	private String title;
	private String contents;
	private String reg_date;
	private Long cat_no;

	public Long getPost_no() {
		return post_no;
	}

	public void setPost_no(Long post_no) {
		this.post_no = post_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public Long getCat_no() {
		return cat_no;
	}

	public void setCat_no(Long cat_no) {
		this.cat_no = cat_no;
	}

}
