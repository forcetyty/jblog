package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.UserDao;
import kr.co.itcen.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//id 검사를 위한 Service
	public Boolean existUser(String id) {
		return userDao.get(id) != null;
	}
	
	//회원가입 Dao
	public Boolean insertUser(UserVo userVo) {
		return userDao.insertUser(userVo) != null;
	}
	
	//로그인 처리를 하는 로직
	public UserVo getUser(UserVo userVo) {
		return userDao.get(userVo);
		
	}
	
	

}
