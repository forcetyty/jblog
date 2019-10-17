package kr.co.itcen.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import kr.co.itcen.jblog.security.AuthUser;
import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.service.PostService;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.PostVo;
import kr.co.itcen.jblog.vo.UserVo;

@Controller
@RequestMapping("/{userId:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	//main 화면 표시되는 로직
	@RequestMapping(value = {"", "/{pathNo1}", "/{pathNo1}/{pathNo2}" })
	public String blogMain(@PathVariable(value = "userId") String userId, 
	@PathVariable(value = "pathNo1") Optional<Long> pathNo1,
	@PathVariable(value = "pathNo2") Optional<Long> pathNo2,
	Model model) {
		
		System.out.println("블로그 메인 화면");
		
		List<CategoryVo> list = categoryService.categoryMain(userId);
		
		model.addAttribute("list", list);
		
		return "blog/blog-main";
	}
	
	// 카테고리 관리화면에서 카테고리 리스트를 가져오는 기능을 수행
	
	@RequestMapping(value = "/blog-admin-category", method = RequestMethod.GET )
	public String blogCategory(@AuthUser UserVo authUser, Model model) {
		
		System.out.println("auth :" + authUser.getId());
		
		List<CategoryVo> list = categoryService.categoryList(authUser.getId());
		model.addAttribute("categoryList", list);
		
		return "blog/blog-admin-category";
	}
	
	@ResponseBody
	@RequestMapping(value = "/blog-admin-category", method = RequestMethod.POST)
	public CategoryVo blogCategoryInsert(@ModelAttribute CategoryVo vo, @AuthUser UserVo authUser
			) {
		System.out.println(vo.toString());
		System.out.println("blog-category Insert Action");

		vo.setId(authUser.getId());
		vo.setName(vo.getName());
		vo.setContents(vo.getContents());
				
		categoryService.categoryInsert(vo);
		
		return vo;
	}
	
	@RequestMapping(value = "/blog-admin-write", method=RequestMethod.GET)
	public String blogWrite(@AuthUser UserVo authUser, Model model) {
		
		System.out.println("blog-admin-write Action");
		List<CategoryVo> list = categoryService.writeCategoryList(authUser.getId());
		model.addAttribute("writeCategoryList", list);
		
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value = "/blog-admin-write", method=RequestMethod.POST)
	public String blogWrite(@ModelAttribute PostVo vo) {
		
		System.out.println("blog-admin-write Process Action");
		postService.postInsert(vo);
		
		return "redirect:/blog/blog-admin-write";
	}
	
	@RequestMapping(value = "/blog-admin-basic")
	public String blogBasic(@AuthUser UserVo authUser, Model model) {
		System.out.println("블로그 관리 화면");
		
		BlogVo vo = blogService.selectBlogInfo(authUser.getId());
		model.addAttribute("blogDefaultInfo", vo);
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value = "/blog-admin-basic", method = RequestMethod.POST)
	public String blogUpdate( BlogVo vo, @AuthUser UserVo authUser,
			@RequestParam(value = "title", required = false)String title,
			@RequestParam(value = "logo-file", required = false)MultipartFile  multipartFile ) {
		
		System.out.println("file Upload 실행");
		System.out.println(	multipartFile) ;
		
		String log = blogService.fileSetup(multipartFile);
		System.out.println("log" + log);
		
		vo.setTitle(title);
		vo.setLog(log);
		vo.setId(authUser.getId());
		
		blogService.updateBlogInfo(vo);
		
		return "redirect:/" + authUser.getId();
	}
	
	
	
	
	
	
	
	

}
