<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 스프링 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- 스프링 Form 라이브러리 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>JBlog</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.servletContext.contextPath }/assets/css/jblog.css" rel="stylesheet" type="text/css">
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {

		$("#id").change(function() {
			$("#btn-check-id").show();
			$("#img-checked").hide();
		});

		/* var btnCheckEamil = $("#btn-check-email"); */
		$("#btn-check-id")
				.click(
						function() {
							//console.log("!!!!!!!!!!!!!");
							var email = $("#id").val();

							if (email == "") {
								return;
							}

							// ajax 통신!!!
							$
									.ajax({
										url : "${pageContext.servletContext.contextPath }/api/user/checkId?id="
												+ id,
										type : "get",
										dataType : "json",
										data : "",
										success : function(response) {
											if (response.result == "fail") {
												console.error(response.message);
												return;
											}

											if (response.data == true) {
												alert("이미 있는 아이디 입니다.");
												$("#id").val("");
												$("#id").focus();
												return;
											}

											$("#btn-check-id").hide();
											$("#img-checkedId").show();
											console.log("사용 가능합니다.")
										},
										error : function(xhr, error) {
											console.error("error:" + error);
										}
									});
						});
	});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<form:form modelAttribute="userVo" id="join-form" name="joinForm" method="post" action="${pageContext.servletContext.contextPath }/user/join">
				<label class="block-label" for="name">이름</label>
				<form:input path="name" />
				<spring:hasBindErrors name="userVo">
					<c:if test='${errors.hasFieldErrors("name") }'>
						<p
							style="font-weight: bold; color: red; text-align: left; padding-left: 0">

							<spring:message code='${errors.getFieldError("name").codes[0] }'
								text='${errors.getFieldError("name").defaultMessage }' />
						</p>
					</c:if>
				</spring:hasBindErrors>

				<label class="block-label" for="blog-id">아이디</label>
				<form:input path="id" />
				<!-- 스크립트단 경로와 맞추어야 한다. -->
				<input id="btn-check-id" type="button" value="id 중복체크">

				<img id="img-checkedId" style="display: none;"
					src="${pageContext.request.contextPath}/assets/images/check.png">

				<p
					style="font-weight: bold; color: red; text-align: left; padding: 5px 0 0 0">
					<form:errors path="id" />
				</p>


				<label class="block-label" for="password">패스워드</label>
				<!-- <input id="password" name="password" type="password" /> -->
				<form:password path="password" />

				<fieldset>
					<legend>약관동의</legend>
					<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
					<label class="l-float">서비스 약관에 동의합니다.</label>
				</fieldset>

				<input type="submit" value="가입하기">
		</form:form>
	</div>
</body>
</html>
