<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name = "pageTitle" value=""/>
</jsp:include>
<section id="content">


<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">이메일</th>
			<th scope="col">성별</th>
			<th scope="col">개발가능언어</th>
		</tr>
		<c:forEach var="dev" items="${list }">
		<tr>
			<td>${dev.devNo }</td>
			<td>${dev.devName}</td>
			<td>${dev.devAge}</td>
			<td>${dev.devEmail}</td>
			<td>${dev.devGender=="M"?"남":"여"}</td>
			<td>
				<c:forEach items="${dev.devLang }" var="lang" varStatus="v">
					${v.index!=0?",":"" }${lang }
				</c:forEach>
			</td>
			<td>
				<button type="button" class="btn btn-light" onclick="">수정</button>
			</td>
			<td>
				<button type="button" class="btn btn-light" onclick="">삭제</button>
			</td>
		</tr>
		</c:forEach>
</table>


</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>