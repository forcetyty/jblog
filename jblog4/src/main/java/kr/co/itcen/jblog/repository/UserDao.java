package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// ID 중복검사를 위한 Dao
	public UserVo get(String id) {
		UserVo result = sqlSession.selectOne("user.getById", id);
		
		return result;
	}
	
	// 회원가입 정보를 넣는 Dao
	public Boolean insertUser(UserVo userVo ) {
		Boolean result = false;
		
		if(userVo != null) {
			sqlSession.insert("user.userinsert", userVo);
			return result = true; 
		}
		return result;
	}
	
	// 로그인 처리를 하는 Dao
	public UserVo get(UserVo vo) {
		UserVo result = sqlSession.selectOne("user.getByIdAndPassword", vo);
		return result;
	}
	
	
	

}
