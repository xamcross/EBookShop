<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Book Title</th>
			<th>Authors</th>
			<th>Price ($)</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${catalog}" var="book">
			<tr>
				<form:form commandName="shoppingCart" cssClass="form-horizontal">
					<td><a
						href='<tags:url value="/EBookShop/catalog/${book.id}.html"/>'>
							${book.title}</a></td>
					<td><c:forEach items="${book.authors}" var="author">
					 ${author.fullName}  
				</c:forEach></td>
					<td>${book.price}</td>
					<td><input type="text" value="${book.id }" hidden="true"><input type="submit" value="Add to cart" 
						class="btn btn-primary" /></td>
				</form:form>
			</tr>

		</c:forEach>
	</tbody>
</table>