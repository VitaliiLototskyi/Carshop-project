<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script>
  function popup() {
	var number = Math.floor(Math.random() * 9000 + 1000);
   document.getElementById('number').innerHTML = number;
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body onload="popup()">
	<div class="row">
		<div class="col-sm-12 col-xs-12">
			<form:form class="form-horizontal" action="/testDrive" method="POST">
				<div class="col-sm-offset-2 col-sm-10 "><h2>Test-Drive</h2></div>
				<div class="form-group">
					<label for="carselect" class="col-sm-offset-2 col-sm-4">The car on which you want to make a test drive *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" placeholder="Example: Mersedes E-Class">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">Enter your full name  *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" placeholder="Example: John Carter">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">City *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" placeholder="Example: London">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">E-Mail: *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">What kind of car you own (brand): *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" placeholder="Example: Opel Astra H">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">Desired date of the test drive:  *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" type="date" name="calendar" lang="en">
				
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">Contact number: *</label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control" placeholder="Example: +37888 88 88">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">Email:<p><small>for those wishing to receive correspondence</small></p></label>
					<div class="col-sm-3 col-sm-offset-1">
						<input class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4">Security code: *</label>
					<div class="col-sm-1 col-sm-offset-1">
						<input class="form-control">
						<div  class ="col-sm-1 col-sm-offset-1" id="number"></div>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-4"><p><small>* - required fields</small></p></label>
				</div>
				<div class="form-group">
					<div  class="col-sm-offset-3 col-sm-7">By pressing the 'send' button, you consent to the processing of your personal data in accordance with current legislation and in compliance with all requirements, "On protection of personal data" as defined in the Law of Ukraine
					</div>
				</div>
				<div class="form-group">
						<div class="col-sm-offset-6 col-sm-6" >
							<a href="/thx">
   								<input type="button" value="Send" />
							</a>
						</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>