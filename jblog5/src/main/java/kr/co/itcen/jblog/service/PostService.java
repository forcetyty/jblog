package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.PostDao;
import kr.co.itcen.jblog.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	// write에서 글이 등록되는 기능
	public boolean postInsert(PostVo vo) {
		Boolean result = false;
		if (vo != null) {
			postDao.postInsert(vo);
			result = true;
		}
		return result;
	}

}
