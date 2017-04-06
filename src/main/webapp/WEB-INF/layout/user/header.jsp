<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-inverse bg-inverse navbar-fixed-top"
	style="margin-bottom: 0px">
	<div class="container-fluid">
		<div class="navbar-header">
		<a class="navbar-brand" href="/" style="padding: 5px"> <img
			src="http://www.videoarts.com/wp-content/uploads/car-shop.png" width="150" height="45" alt=""
			style="padding-bottom: 5px; margin-bottom: 0px">
		</a>
			<ul class="nav navbar-nav">
				<li><a href="/">Home</a></li>
				<li><a href="/carshop">Cars</a></li>
				<li><a href="/testDrive">Test Drive</a></li>
				<li><a href="/contacts">Contacts</a></li>
				<li><a href="/about">About us</a></li>
				
			</ul>
		</div>
		<div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<security:authorize access="!isAuthenticated()">
						<a class="btn btn-primary" href="/registration"
							style="margin: 10px">Registration</a>
						<a class="btn btn-primary" href="/login"
							style="margin: 10px; margin-left: 0px">Login</a>
					</security:authorize>

					<security:authorize access="isAuthenticated() and hasRole('ROLE_USER')">
						<form:form class="navbar-form navbar-right" action="/logout"
							method="POST">
							<button class="btn btn-primary" style="margin-right: 10px">Sign
								out</button>
						</form:form>
					</security:authorize>
					<security:authorize
						access="isAuthenticated() and hasRole('ROLE_ADMIN')">
						<form:form class="navbar-form navbar-right"
							 action="/admin" method="POST">
							<button class="btn btn-primary" style="margin-right: 10px">Admin</button>
						</form:form>
						<form:form class="navbar-form navbar-right" action="/logout" method="POST">
							<button class="btn btn-primary">Logout</button>
						</form:form>
					</security:authorize>

				</ul>
			</div>
		</div>
	</div>

</nav>