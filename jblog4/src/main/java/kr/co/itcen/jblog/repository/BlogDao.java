package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	// User 생성시 기본값 설정해주는 기능
	public boolean defaultBlog(String id) {
		Boolean result = false;
		if (id != null) {
			sqlSession.insert("blog.defaultBlog", id);
			result = true;
		}
		return result;
	}

	// Blog Basic에서 Blog의 기본정보를 출력해주는 기능
	public BlogVo selectBlogInfo(String id) {
		BlogVo vo = sqlSession.selectOne("blog.selectBlogInfo", id);
		return vo;
	}

	// Blog Basic에서 Blog의 기본정보를 수정해주는 기능
	public Boolean updateBlogInfo(BlogVo vo) {
		Boolean result = false;
		if (vo != null) {
			sqlSession.update("blog.updateBlogInfo", vo);
			result = true;
		}
		return result;
	}

}
