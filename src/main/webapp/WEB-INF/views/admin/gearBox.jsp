<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row" style="margin-top: 30px">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				
					<li><a href="/admin/car">Car</a></li>
					<li><a href="/admin/model">Model</a></li>
					<li class="active"><a href="/admin/gearBox">Gearbox</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/engine">Engine</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/color">Color</a></li>
				

				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/gearBox" method="POST" modelAttribute="gearBox">
				<form:errors path="*"/>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Gearbox type</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="gearType" id="gearTypeId" items="${gearTypes}"/>
							
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Gear count</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="count" id="countId"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3">
				<h3>Gear count</h3>
			</div>
			<div class="col-md-3 col-xs-">
				<h3>Type</h3>
			</div>
			<div class="col-md-3 col-xs-">
				<h3>Update</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${gearBoxes}" var="gearBox">
			<div class="row">
				<div class="col-md-3 col-xs-3">${gearBox.count}</div>
				<div class="col-md-3 col-xs-3">${gearBox.gearType}</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning"
						href="/admin/gearBox/update/${gearBox.id}">update</a>
				</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-danger"
						href="/admin/gearBox/delete/${gearBox.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>