package kr.co.itcen.jblog.vo;

public class CommentVo {

	private Long comm_no;
	private String contents;
	private String reg_date;
	private Long g_no;
	private Long o_no;
	private Long depth;
	private Long post_no;

	public Long getComm_no() {
		return comm_no;
	}

	public void setComm_no(Long comm_no) {
		this.comm_no = comm_no;
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

	public Long getG_no() {
		return g_no;
	}

	public void setG_no(Long g_no) {
		this.g_no = g_no;
	}

	public Long getO_no() {
		return o_no;
	}

	public void setO_no(Long o_no) {
		this.o_no = o_no;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public Long getPost_no() {
		return post_no;
	}

	public void setPost_no(Long post_no) {
		this.post_no = post_no;
	}

}
