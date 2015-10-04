<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<h1>${book.title }</h1>

<c:forEach items="${book.authors}" var="author">
	${author.fullName}
</c:forEach>