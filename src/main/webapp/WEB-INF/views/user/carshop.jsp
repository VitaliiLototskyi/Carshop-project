<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<style>
.block span {
	display: block;
}

.block2 span {
	display: block;
}
</style>
<div class="row" style="margin-top: 30px">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/carshop" method="get"
			class="form-inline">
			<form:errors path="*" />
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
				<div class="col-sm-4 col-xs-4">
					<form:input type="text" class="form-control" path="maxPrice"
						placeholder="Max price" style="padding-right: 0px" />
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
						placeholder="Max year" style="padding-right: 0px" />
				</div>
			</div>
			<div class="form-group block2">
				<div class="col-sm-12">
					<h4>Search by color</h4>
					<form:checkboxes items="${colors}" path="colorIds" id="colorId"
						itemLabel="color" itemValue="id" />
				</div>
			</div>
			<div class="form-group block">
				<div class="col-sm-12">
					<h4>Search by producer</h4>
					<form:checkboxes items="${producers}" path="producerIds"
						id="producerId" itemLabel="name" itemValue="id" />
					<!-- 				 path - name of List  -->
				</div>
			</div>
			<div>
				<div class="col-sm-12" style="margin-top: 20px">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<h4>Car List</h4>
		<c:forEach items="${page.content}" var="car">
			<div class="carName"
				style="border: 1px solid #bfbfbf; border-left: 2px solid #337ab7">
				<div style="margin: 10px; font-size: 16px">
					<font color="#337ab7"><strong>${car.name}
							${car.model.name} - ${car.model.engine.sweptVolume}</strong></font>
				</div>
			</div>
			<div class="carContent"
				style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px">
				<div class="row">
					<div class="col-md-2 col-xs-3 picture">
						<img class="img" width="150" height="140"
							src="/images/car/${car.id}.jpg?version=${car.version}"
							style="padding: 2px; border: 1px solid grey">
					</div>
					<div class="col-md-8 col-xs-6 description">
						<ul>
							<li class="Year"><strong>Year:</strong> ${car.year}</li>
							<li class="BodyStyle"><strong>Body type:</strong>
								${car.bodyStyle}</li>
							<li class="FuelType"><strong>Fuel type:</strong>
								${car.model.engine.engineType}</li>
							<li class="Engine"><strong>Engine:</strong>
								${car.model.engine.sweptVolume }</li>
							<li class="GearBoxType"><strong>Gearbox type:</strong>
								${car.gearBox.gearType }</li>
							<li class="Color"><strong>Color:</strong> ${car.color.color }</li>
						</ul>
					</div>
					<div class="col-md-2 price" style="margin-top: 30px">
						<div>${car.model.price }€</div>
						<security:authorize access="!isAuthenticated()">
							<div>
								<a href="/login" style="color: #383f43"> <input
									type="submit" class="btn btn-default" value="Order"
									style="color: #383f43; border: 2px solid #666" />
								</a>
							</div>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<div>
								<a href="/ordernow/${car.id}" style="color: #383f43"> <input type="submit"
									class="btn btn-default" value="Order"
									style="color: #383f43; border: 2px solid #666" />
								</a>
							</div>
						</security:authorize>
					</div>
				</div>
			</div>
			<div class="" style="text-align: center">
				${car.name }
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
