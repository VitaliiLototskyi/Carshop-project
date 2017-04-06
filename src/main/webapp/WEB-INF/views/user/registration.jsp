<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="userForm">
			<div class="form-group">
				<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="username"/></label>
			</div>
			<div class="form-group">
				<form:errors path="username" />
    			<label for="name" class="col-sm-3 control-label">Login</label>
    			<div class="col-sm-7">
      				<form:input class="form-control" path="username" id="name"/>
    			</div>
  			</div>
  			<div class="form-group">
  			<form:errors path="email" />
				<label for="email" class="col-sm-offset-3 col-sm-7"><form:errors path="email"/></label>
			</div>
			<div class="form-group">
    			<label for="email" class="col-sm-3 control-label">Email</label>
    			<div class="col-sm-7">
      				<form:input class="form-control" path="email" id="email" type="email"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" class="col-sm-offset-3 col-sm-7"></label>
			</div>
			<div class="form-group">
				<form:errors path="password" />
    			<label for="password" class="col-sm-3 control-label">Password</label>
    			<div class="col-sm-7">
      				<form:password class="form-control" path="password" id="password"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-3 col-sm-7">
      				<button type="submit" class="btn btn-primary">Register</button>
    			</div>
  			</div>
		</form:form>
	</div>
</div>