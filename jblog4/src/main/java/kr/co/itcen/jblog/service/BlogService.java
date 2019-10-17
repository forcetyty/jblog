package kr.co.itcen.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	private static final String SAVE_PATH = "/Users/Force/eclipse-workspace-bit/jblog-log";

	@Autowired
	private BlogDao blogDao;

	// User 생성시 기본값을 설정해주는 기능
	public boolean defaultBlog(String id) {
		Boolean result = false;
		if (id != null) {
			blogDao.defaultBlog(id);
			result = true;
		}
		return result;
	}

	// Blog Basic에서 Blog의 기본정보를 출력해주는 기능
	public BlogVo selectBlogInfo(String id) {
		BlogVo vo;
		vo = blogDao.selectBlogInfo(id);
		return vo;
	}
	
	// Blog Basic 정보를 수정해주는 기능
	public boolean updateBlogInfo(BlogVo vo) {
		Boolean result = false;
		if (vo != null) {
			blogDao.updateBlogInfo(vo);
			result = true;
		}
		return result;
	}

	// file 저장 - 현재 파일저장 경로  SAVE_PATH = "/Users/Force/eclipse-workspace-bit/jblog3/jblog-log";
	public String fileSetup(MultipartFile multipartFile) {
		String url = "";
		
		try {
			if (multipartFile == null) {
				return url;
			}
	
			String originalFilename = multipartFile.getOriginalFilename();
			String saveFileName = generateSaveFileName(originalFilename.substring(originalFilename.lastIndexOf('.') + 1));
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH+"/"+saveFileName);
			
			os.write(fileData);
			os.close();
			
		return url = saveFileName;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 저장 오류 발생");
			e.printStackTrace();
		}
		
		return url;
	}

	private String generateSaveFileName(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += "." + extName;
		return filename;
	}

}
