<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Book Title</th>
			<th>Authors</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${catalog}" var="book">
			<tr>
				<td><a href='<tags:url value="/EBookShop/catalog/${book.id}.html"/>'>
				${book.title}</a></td>
<td>
				<c:forEach items="${book.authors}" var="author">
					| ${author.fullName} | 
				</c:forEach>
				</td>
				<td><a href="#">Add to Cart</a></td>
			</tr>

		</c:forEach>
	</tbody>
</table>