package kr.co.itcen.jblog.vo;

public class CategoryVo {

	private Long cat_no; // 카테고리 번호
	private String name; // 카테고리 이름
	private String contents; // 카테고리 설명
	private String reg_date; // 카테고리 등록날짜
	private String id; // 블로그 아이디
	private Long cat_count; // 카테고리 전체 수량

	public Long getCat_no() {
		return cat_no;
	}

	public void setCat_no(Long cat_no) {
		this.cat_no = cat_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCat_count() {
		return cat_count;
	}

	public void setCat_count(Long cat_count) {
		this.cat_count = cat_count;
	}

	@Override
	public String toString() {
		return "CategoryVo [cat_no=" + cat_no + ", name=" + name + ", contents=" + contents + ", reg_date=" + reg_date
				+ ", id=" + id + ", cat_count=" + cat_count + "]";
	}

}
