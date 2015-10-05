<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="add-book" cssClass="form-horizontal">
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">Title:</label>
		<div class="col-sm-10">
			<form:input path="title" cssClass="form-control" />
		</div>

	</div>
	<div class="form-group">
		<label for="authors" class="col-sm-2 control-label">Authors:</label>

		<div class="col-sm-10">
			<form:input path="authors" cssClass="form-control" />
			<!-- does not work, Author is a distinct type, not a String -->
		</div>

	</div>
	<div class="form-group">
		<label for="price" class="col-sm-2 control-label">Price:</label>
		<div class="col-sm-10">
			<form:input path="price" cssClass="form-control" />
		</div>

	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Add to catalog"
				class="btn btn-lg btn-primary" />
		</div>

	</div>
</form:form>