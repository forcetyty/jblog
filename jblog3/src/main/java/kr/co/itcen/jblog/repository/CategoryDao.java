package kr.co.itcen.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	// User 생성시 기본 카테고리 값을 생성하는 기능
	public boolean defaultCategory(String id) {
		Boolean result = false;
		if (id != null) {
			sqlSession.insert("category.defaultCategory", id);
			result = true;
		}
		return result;
	}

	// 메인화면에서 카테고리 목록을 출력해주는 기능
	public List<CategoryVo> categoryMain(String userId) {
		List<CategoryVo> list = sqlSession.selectList("category.categorymain", userId);
		return list;
	}

	// 카테고리에서 카테고리 목록을 출력해주는 기능
	public List<CategoryVo> categoryList(String userId) {
		List<CategoryVo> list = sqlSession.selectList("category.categoryList", userId);
		return list;
	}

	// 카테고리 목록을 입력하는 기능
	public boolean categoryInsert(CategoryVo vo) {
		Boolean result = false;
		if (vo != null) {
			sqlSession.insert("category.categoryInsert", vo);
			result = true;
		}
		return result;
	}
	
	// write에서 카테고리 리스트를 가져오는 기능
	public List<CategoryVo> writeCategoryList(String userId){
		List<CategoryVo> list = sqlSession.selectList("category.writeCategoryList", userId);
		return list;
	}

}
