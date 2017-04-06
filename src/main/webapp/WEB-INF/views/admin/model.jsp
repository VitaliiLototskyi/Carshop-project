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
						<li class="active"><a href="/admin/model">Model</a>
						<span class="sr-only">(current)</span></li>
					<li><a href="/admin/gearBox">Gearbox</a></li>
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
				<form:form class="form-horizontal" action="/admin/model" method="POST" modelAttribute="model">
				<form:errors path="*"/>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Producer</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="producer" id="producerId" items="${producers}" itemValue="id" itemLabel="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Engine</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="engine" id="engineId" items="${engines}" itemValue="id" itemLabel="sweptVolume"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Model name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="name" id="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Price</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="price" id="price"/>
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
				<h3>Model</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Price</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Update</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${models}" var="model">
			<div class="row">
				<div class="col-md-3 col-xs-3">${model.name}</div>
				<div class="col-md-3 col-xs-3">${model.price}</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning"
						href="/admin/model/update/${model.id}">update</a>
				</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-danger"
						href="/admin/model/delete/${model.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>