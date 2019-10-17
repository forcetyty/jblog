package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	// User 생성시 default 값 생서하는 기능
	public boolean defaultCategory(String id) {
		Boolean result = false;
		if (id != null) {
			categoryDao.defaultCategory(id);
			result = true;
		}
		return result;
	}

	// main Page에서 카테고리 목록이 보이도록 하는 기능
	public List<CategoryVo> categoryMain(String userId) {
		List<CategoryVo> list = categoryDao.categoryMain(userId);
		return list;
	}

	// 카테고리 설정에서 카테고리 리스트를 보이도록 하는 기능
	public List<CategoryVo> categoryList(String userId) {
		List<CategoryVo> list = categoryDao.categoryList(userId);
		return list;
	}

	// 카테고리 목록을 추가하는 기능
	public boolean categoryInsert(CategoryVo vo) {
		Boolean result = false;
		if (vo != null) {
			categoryDao.categoryInsert(vo);
			result = true;
		}
		return result;
	}
	
	// write에서 카테고리 리스트를 가져오는 기능
	public List<CategoryVo> writeCategoryList(String userId){
		List<CategoryVo> list = categoryDao.writeCategoryList(userId);
		return list;
	}

}
