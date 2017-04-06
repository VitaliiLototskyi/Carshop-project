<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
.block span {
	display: block;
}

.block2 span {
	display: block;
}
</style>
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

					<li class="active"><a href="/admin/car">Car</a> <span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/model">Model</a></li>
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
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/car" method="get"
			class="form-inline">
			<div class="form-group">
				<div class="col-sm-12">
					<h4>Search by name</h4>
					<form:input path="search" placeholder="Search" class="form-control" />
					<custom:hiddenInputs
						excludeParams="_colorIds, _producerIds, search, minPrice, maxPrice, producerIds, modelIds, engineIds, gearBoxIds, countryIds, minYear, maxYear , colorIds" />
				</div>
			</div>
			<div class="form-group">
				<h4 style="margin-left: 15px">Search by price</h4>
				<div class="col-sm-5 col-xs-5">
					<form:input type="text" class="form-control" path="minPrice"
						placeholder="Min price" />
				</div>
				<div class="col-sm-5 col-xs-5">
					<form:input type="text" class="form-control" path="maxPrice"
						placeholder="Max price" />
				</div>
			</div>
			<div class="form-group">
				<h4 style="margin-left: 15px">Search by year</h4>
				<div class="col-sm-5 col-xs-5">
					<form:input type="text" class="form-control" path="minYear"
						placeholder="Min year" />
				</div>
				<div class="col-sm-5 col-xs-5">
					<form:input type="text" class="form-control" path="maxYear"
						placeholder="Max year" />
				</div>
			</div>
			<div class="form-group block2">
				<div class="col-sm-12">
					<h4 style="margin-top: 35px">Search by color</h4>
					<form:checkboxes items="${colors}" path="colorIds" id="colorId"
						itemLabel="color" itemValue="id" />
				</div>
			</div>
			<div class="form-group block">
				<div class="col-sm-12">
					<h4>Search by producer</h4>
					<form:checkboxes items="${producers}" path="producerIds"
						id="producerId" itemLabel="name" itemValue="id" />
					<!-- 						 path - name of List -->
				</div>
			</div>
			<div>
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>


		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/car" method="POST"
					modelAttribute="car" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="name,model,gearBox,color" />
					<form:errors path="*" />
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="name" /></label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Model</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="model" id="modelId"
								items="${models}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<!-- 					<div class="form-group"> -->
					<!-- 						<label for="name" class="col-sm-2 control-label">Price</label> -->
					<!-- 						<div class="col-sm-10"> -->
					<%-- 							<form:select class="form-control" path="model" id="modelId" items="${models}" itemValue="id" itemLabel="price"/> --%>
					<!-- 						</div> -->
					<!-- 					</div> -->
					<div class="form-group">
						<label for="color" class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="color" id="colorId"
								items="${colors}" itemValue="id" itemLabel="color" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">GearBox</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="gearBox" id="gearBoxId"
								items="${gearBoxes}" itemValue="id" itemLabel="count" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Car Name</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" path="name"
								id="name" />
						</div>
						<label for="year" class="col-sm-1 control-label">Year</label>
						<div class="col-sm-5">
							<form:input type="text" class=" form-control" path="year"
								id="yearId" />
						</div>
					</div>
					<div class="form-group">
						<label for="bodyStyle" class="col-sm-2 control-label">Body
							Style</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="bodyStyle"
								id="bodyStyleId" items="${bodyStyles}"></form:select>
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<label class="btn btn-default btn-file"> Browse <input
								type="file" name="file" style="display: none;">
							</label>
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
			<div class="col-md-2 col-xs-2">
				<h3>Image</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Car name</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Model</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Year</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Color</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Update</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="car">
			<div class="row">
				<div class="col-md-2 col-xs-2">
					<img class="img-rounded" width="100%"
						src="/images/car/${car.id}.jpg?version=${car.version}">
				</div>
				<div class="col-md-2 col-xs-2">${car.name}</div>
				<div class="col-md-2 col-xs-2">${car.model.name}</div>
				<div class="col-md-1 col-xs-1">${car.year}</div>
				<div class="col-md-1 col-xs-1">${car.color.color}</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning"
						href="/admin/car/update/${car.id}<custom:allParams/>">update</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger"
						href="/admin/car/delete/${car.id}<custom:allParams/>">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name" />
						<custom:sort innerHtml="Name desc" paramValue="name,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>