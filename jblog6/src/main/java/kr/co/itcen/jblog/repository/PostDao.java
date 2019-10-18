package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// write 
	public boolean postInsert(PostVo vo) {
		Boolean result = false;
		if(vo != null) {
			sqlSession.insert("post.postInsert", vo);
			return result = true; 
		}
		return result;
	}

}
