<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.servletContext.contextPath }/assets/css/jblog.css">
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("#categoryButton").click( function(){
		var formData = $("#categoryId").serialize();
		var rowcnt = $("#categoryTable tr").length;
		
		alert(formData);
		$.ajax({
		url : "${pageContext.servletContext.contextPath }/blog/blog-admin-category",
		type : "post",
		data : formData,
		success : function(response) {
			
				$("#categoryTable").append("<tr id='category_"+rowcnt+"'><td></td>"+
						"<td>"+ response.name + " </td>"+
						"<td>"+ response.cat_count + "</td>"+
						"<td>"+ response.contents + "</td>"+
						"<td><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>"+
					"</tr>")
			
		}
		}); 
	});  
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header-blog.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/include/admin-menu-blog.jsp" />
				<table class="admin-cat" id="categoryTable">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<c:set var="count" value='${fn:length(categoryList)}'/>
					<c:forEach items='${categoryList }' var='vo' varStatus='status'>
						<tr id="category_${vo.cat_no }">
							<td>${count - status.index }</td>
							<td>${vo.name} </td>
							<td>${vo.cat_count }</td>
							<td>${vo.contents }</td>
							<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>
					</c:forEach>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form class="category-form" name="category" id="categoryId" method="post">
				<table id="admin-cat-add">
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="contents"></td>
					</tr>
					<tr>
						<td class="s">&nbsp;</td>
						<td><input type="button" id="categoryButton" value="카테고리 추가"></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer-blog.jsp" />
	</div>
</body>
</html>