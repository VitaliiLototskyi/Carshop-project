
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!-- <script src="http://bootstrap-ru.com/204/assets/js/bootstrap-carousel.js"></script> -->


<div class="section-body">
	<div class="row Carousel">
		<div class="col-sm-offset-2 col-sm-8 ">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
					<li data-target="#myCarousel" data-slide-to="5"></li>
					<li data-target="#myCarousel" data-slide-to="6"></li>
					<li data-target="#myCarousel" data-slide-to="7"></li>
					<li data-target="#myCarousel" data-slide-to="8"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="https://wallpaperscraft.com/image/bmw_m3_blue_car_side_view_tuning_96814_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/chevrolet_corvette_stingray_c7_95549_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/nissan_auto_black_street_87159_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/porsche_auto_car_cars_red_79763_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/bmw_e92_yellow_side_view_96550_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/subaru_impreza_wrx_sti_cars_style_white_83295_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/ford_mustang_cars_traffic_83240_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/nissan_370z_tuning_blue_side_view_96552_1920x1080.jpg" alt="Car">
					</div>
					<div class="item">
						<img src="https://wallpaperscraft.com/image/mercedes_benz_gle_coupe_white_side_view_110134_1920x1080.jpg" alt="Car">
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#myCarousel").carousel();
	</script>
	<div class="row" style="margin-top: 50px; margin-bottom: 50px">
		<div class="col-sm-offset-2 col-sm-8 ">
			<h2 style="text-align: center; text-transform: uppercase">The
				cars with a look into the future.</h2>
			<p style="text-align: center; font-size: large; font-style: italic">Quality
				- rule. Price - exception!</p>
		</div>
	</div>
	<div class="container">
		<div class="row row-no-padding">
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-jazz">
					<img src="http://www.honda.ie/templates/honda2015/public/new-cars/list/new-jazz.jpg" width="293" height="293"
						alt="car">
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-hrv">
					<img alt="car" src="http://www.honda.ie/templates/honda2015/public/new-cars/list/new-civic.jpg" width="293"
						height="293">
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-find">
					<img alt="car" src="http://www.honda.ie/templates/honda2015/public/new-cars/list/hr-v.jpg" width="293"
						height="293">
				</div>
			</div>
		</div>
		<div class="row row-no-padding">
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-nsx">
					<img alt="car" src="http://www.honda.ie/templates/honda2015/public/new-cars/list/cr-v.jpg" width="293"
						height="293">
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-char">
					<img alt="car" src="http://www.honda.ie/templates/honda2015/public/new-cars/list/nsx.jpg" width="293"
						height="293">
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="new-car-crv">
					<img alt="car" src="http://www.honda.ie/templates/honda2015/public/new-cars/list/civic-type-r.jpg" width="293"
						height="293">
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<security:authorize access="!isAuthenticated()">
					<div class="new-icon">
						<a href="/login"> <img alt="car"
							src="https://thumb1.shutterstock.com/display_pic_with_logo/2836291/293819024/stock-vector-logo-for-car-washing-on-a-white-background-car-logo-logo-of-car-cleaning-blue-logo-of-car-293819024.jpg" width="293" height="293"></a>
					</div>
				</security:authorize>
				<security:authorize
					access="isAuthenticated() and hasRole('ROLE_USER')">
					<div class="new-icon">
						<a href="/carshop"> <img alt="car"
							src="https://thumb1.shutterstock.com/display_pic_with_logo/2836291/293819024/stock-vector-logo-for-car-washing-on-a-white-background-car-logo-logo-of-car-cleaning-blue-logo-of-car-293819024.jpg" width="293" height="293"></a>
					</div>
				</security:authorize>
				<security:authorize
					access="isAuthenticated() and hasRole('ROLE_ADMIN')">
					<div class="new-icon">
						<a href="/admin/car"> <img alt="car"
							src="https://thumb1.shutterstock.com/display_pic_with_logo/2836291/293819024/stock-vector-logo-for-car-washing-on-a-white-background-car-logo-logo-of-car-cleaning-blue-logo-of-car-293819024.jpg" width="293" height="293"></a>
					</div>
				</security:authorize>

			</div>
		</div>
	</div>
</div>