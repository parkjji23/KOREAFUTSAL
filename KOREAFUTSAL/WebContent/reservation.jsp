<%@page import="model.ComResInfoDto"%>
<%@page import="model.ReservationDto"%>
<%@page import="model.ReservationList_Action"%>
<%@page import="model.BranchDto"%>
<%@page import="model.GroundDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String url = request.getServletPath();
	session.setAttribute("url", url);
	String includeurl = "header.jsp";
	String uss = (String) session.getAttribute("id");
	String log = "로그인";
	if (uss == null)
		uss = "GUEST";
	else {
		log = "로그아웃";
		includeurl = "sign_login.jsp";
	}
%>
<%
	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) request.getAttribute("BranchList");
	ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) request.getAttribute("GroundList");
	ArrayList<ReservationDto> ReservationList = (ArrayList<ReservationDto>) request.getAttribute("ReservationList");
	ArrayList<ComResInfoDto> fulldatelist = (ArrayList<ComResInfoDto>) request.getAttribute("fulldatelist");
%>
<!-- 로그아웃 상태로 대관페이지 가는것 막기 ************-->
<%
	if (uss == "GUEST") {
%>
<script>
	alert("로그인 후 이용해주세요");
	window.history.back();
</script>
<%
	}
%>
<!-- ************************************ -->
<!-- datepicker -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- <link rel='stylesheet' type='text/css' href='http://fian.my.id/Waves/static/waves.min.css?v=0.7.4'> -->
<link rel='stylesheet' type='text/css' href='css/rm-datepicker.css'>
<!-- ---------- -->
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html>
<html lang="en">
<head>
<title>대관신청</title>
<meta charset="UTF-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta content="Chrissy Collins" name="author">
<meta content="A pure vanilla JS calendar by @chrisssycollins" name="description">
<link href="css/vanillaCalendar.css" rel="stylesheet">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/classic.css">
<link rel="stylesheet" href="css/classic.date.css">
<link rel="stylesheet" href="css/classic.time.css">
<link rel="stylesheet" href="css/orbit-1.2.3.css">
<link rel="stylesheet" href="css/reservation_body.css">
<link rel="stylesheet" href="css/demo-style.css">
<link rel="stylesheet" href="css/style2.css" media="screen">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:100,300,400'>
<link rel="stylesheet" href="css/selectstyle.css">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/form_check.js"></script>
<script type="text/javascript" src="jquery-1.5.1.min.js"></script>
<link rel="stylesheet" href="reservation_body.css">
<!----------------------------바디 스타일------------------------------------>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>

<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
<!-- select box -->
<script src="js/selectindex.js"></script>
<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">
<!----------------------------회원가입스크립트랑 스타일(따로 빼면 에러)-------------------------->
<script type='text/javascript'>
	$(function() {
		$('#forgot_username_link').tipsy({
			gravity : 'w'
		});
	});
</script>
<link href="css/front.css" media="screen, projection" rel="stylesheet" type="text/css">
<script src="js/jquery2.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$(".signin").click(function(e) {
			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin").toggleClass("menu-open");
		});

		$("fieldset#signin_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}
		});

	});
</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>

<script type="text/javascript">
	$(window).load(function() {
		$('#featured').orbit();
	});
</script>

<script>
	/*스크롤 내리면 메뉴 위치 이동하는 기능------따로빼면 작동xxxxxx*/
	$(function() {
		var shrinkHeader = 30;
		var shrinkhollow = 465;
		$(window).scroll(function() {
			var scroll = getCurrentScroll();
			if (scroll >= shrinkHeader) {
				$('#navtop').addClass('shrink');
			} else {
				$('#navtop').removeClass('shrink');
			}
			if (scroll >= shrinkhollow) {
				$('#navtop').addClass('shrinkhollow');
			} else {
				$('#navtop').removeClass('shrinkhollow');
			}
		});
		function getCurrentScroll() {
			return window.pageYOffset || document.documentElement.scrollTop;
		}
	});
</script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<!-- <script src="http://fian.my.id/Waves/static/waves.min.js?v=0.7.4"></script> -->
<script src="js/rm-datepicker.js"></script>
<script>

var FULLDATE = new Array();
<%for (int i = 0; i < fulldatelist.size(); i++) {%>
FULLDATE[<%=i%>] = "<%=fulldatelist.get(i).getRes_date()%>";
<%}%>

</script>
<script>
	var app = angular.module("myApp", [ "rmDatepicker" ]);

	/* Datepicker global configuration */
	app.config([ "rmDatepickerConfig", function(rmDatepickerConfig) {
		rmDatepickerConfig.mondayStart = true;
		rmDatepickerConfig.initState = "month";
	} ]);
</script>
<script>
	(function() {
		var app = angular.module("myApp");
		var MyCtrl = function($scope) {
			/* Datepicker local configuration */
			$scope.rmConfig1 = {
				mondayStart : false,
				initState : "month", /* decade || year || month */
				maxState : "decade",
				minState : "month",
				decadeSize : 12,
				monthSize : 42, /* "auto" || fixed nr. (35 or 42) */
				min : new Date(),
				max : new Date('2060-12-31'),
				/* checkdate : new Date('2020-03-15'),  */
				format : "yyyy-MM-dd" /* https://docs.angularjs.org/api/ng/filter/date */
			};
			$scope.oDate1 = new Date();
			$scope.oDate2 = new Date();
		};
		app.controller("MyCtrl", [ '$scope', MyCtrl ]);
	}());
	// Init waves (OPTIONAL) :)
	// window.onload = Waves.init();
</script>
<SCRIPT type="text/javascript">
	
</SCRIPT>
<style>
.box {
	width: 450px;
}
</style>
<!-- datepicker -->
<style>
.container {
	max-width: 320px;
}

h1 {
	line-height: 15px;
}

/* input {
	width: 100%;
	height: 20px;
} */
</style>
<!-- -------- -->
<style>
.inputGroup {
	background-color: #fff;
	display: block;
	margin: 10px 0;
	position: relative;
}

.inputGroup label {
	padding: 12px 30px;
	width: 100%;
	display: block;
	text-align: center;
	color: #3C454C;
	cursor: pointer;
	position: relative;
	z-index: 2;
	-webkit-transition: color 200ms ease-in;
	transition: color 200ms ease-in;
	overflow: hidden;
	letter-spacing: 4px;
}

.inputGroup label:before {
	width: 100%;
	height: 10px;
	border-radius: 50%;
	content: '';
	background-color: #4c89cd;
	position: absolute;
	left: 50%;
	top: 50%;
	-webkit-transform: translate(-50%, -50%) scale3d(1, 1, 1);
	transform: translate(-50%, -50%) scale3d(1, 1, 1);
	-webkit-transition: all 300ms cubic-bezier(0.4, 0, 0.2, 1);
	transition: all 300ms cubic-bezier(0.4, 0, 0.2, 1);
	opacity: 0;
	z-index: -1;
}

.inputGroup label:after {
	width: 32px;
	height: 32px;
	content: '';
	border: 2px solid #D1D7DC;
	background-color: #fff;
	background-image:
		url("data:image/svg+xml,%3Csvg width='32' height='32' viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M5.414 11L4 12.414l5.414 5.414L20.828 6.414 19.414 5l-10 10z' fill='%23fff' fill-rule='nonzero'/%3E%3C/svg%3E ");
	background-repeat: no-repeat;
	background-position: 2px 3px;
	border-radius: 50%;
	z-index: 2;
	position: absolute;
	right: 30px;
	top: 50%;
	-webkit-transform: translateY(-50%);
	transform: translateY(-50%);
	cursor: pointer;
	-webkit-transition: all 200ms ease-in;
	transition: all 200ms ease-in;
}

.inputGroup input:checked ~ label {
	color: #fff;
}

.inputGroup input:checked ~ label:before {
	-webkit-transform: translate(-50%, -50%) scale3d(56, 56, 1);
	transform: translate(-50%, -50%) scale3d(56, 56, 1);
	opacity: 1;
}

.inputGroup input:checked ~ label:after {
	background-color: #003e73;
	border-color: #003e73;
}

.inputGroup input {
	width: 32px;
	height: 32px;
	-webkit-box-ordinal-group: 2;
	order: 1;
	z-index: 2;
	position: absolute;
	right: 30px;
	top: 50%;
	-webkit-transform: translateY(-50%);
	transform: translateY(-50%);
	cursor: pointer;
	visibility: hidden;
}

.inputGroup form {
	padding: 0 16px;
	max-width: 550px;
	margin: 50px auto;
	font-size: 18px;
	font-weight: 600;
	line-height: 36px;
}

body .inputGroup {
	background-color: #D1D7DC;
	font-family: 'Fira Sans', sans-serif;
}

.inputGroup, .inputGroup::before, .inputGroup::after {
	box-sizing: inherit;
}

.inputGroup {
	box-sizing: border-box;
}

code {
	background-color: #9AA3AC;
	padding: 0 8px;
}

#ground_name {
	width: 1002px;
	height: 47px;
	font-size: 17px;
}
</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet"><!-- font-family:'Nanum Gothic', sans-serif -->

<style>
input[type=button]{
font-weight:bold;
}
input[type=submit]{
font-weight:bold;
}
*{
font-family:'Nanum Gothic', sans-serif;
}
.league_cont .teams_table .search_wrap button span {
    display: inline-block;
    padding-right: 30px;
    background: url(img/icon_league_search_s.png) no-repeat right center;
    background-size: auto 40px;
    color: #fff;
    font-size: 18px;
    font-weight: 700;
}
.league_cont .select label {
    position: absolute;
    top: 0px;
    right: 20px;
    bottom: 0;
    left: 10px;
    color: #404040;
    font-size: 16px;
    line-height: 38px;
    text-align: left;
}
.h_tit {
    position: relative;
    margin-bottom: 45px;
    padding-bottom: 24px;
    font-size: 50px;
    font-family: 'NanumBarunGothicL';
    line-height: 60px;
    text-align: center;
}
.h_tit:after {
    content: "";
    display: block;
    position: absolute;
    bottom: 0;
    left: 50%;
    margin-left: -49px;
    width: 98px;
    height: 2px;
    background: #bfc4cc;
}
</style>
<!-- 통합버튼CSS 추가 -->
<link rel="stylesheet" href="css/Button-futsalpark.css">
</head>
<body>
	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>

	<div id="mainleft" style="height: 1600px;">
		<div id="leftbanner">
			<div id="banner1">
				<img src="img/20191211.jpg" width="100%" height="100%" />
			</div>
			<div id="banner3">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.265446899888!2d127.02924799651784!3d37.492391917303266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5bed583f92d%3A0xc93c837d2875ade6!2z7ZKL7IK07J6l!5e0!3m2!1sko!2skr!4v1575961834128!5m2!1sko!2skr" width="100%" height="100%" frameborder="0" style="border: 0;" allowfullscreen=""></iframe>
			</div>
		</div>
	</div>



	<section id="main">
		<section id="mainright" style="margin-top: 60px;">
		<h3 class="h_tit" style="font-weight:normal;">대 관 </h3>
			<form name="join" id="materialForm" class="form" method="post" role="form" autocomplete="off">

				<%
					if (GroundList != null) {
				%>
				<!------------------------------ datepicker ---------------------------->
				<!-- 아랫줄 max-width:달력 가로길이 -->
				<div ng-app="myApp" ng-controller="MyCtrl" class="container" style="max-width: 1025px; margin-left: -12px;">

					<div rm-datepicker ng-model="oDate1" rm-config="rmConfig1" class="datepick"></div>
					<br>
					<div style="font-size: 18px; text-align: left; letter-spacing: 1px;">
						<input type="hidden" name="hiddendate" value="{{oDate1 | date: 'yyyy-MM-dd'}}" id="hiddendate">
						날짜선택 : {{oDate1 | date: 'yyyy-MM-dd'}}
						<label id="weeklabel" for="weeklabel"></label>

						<script type="text/javascript">
								$(".datepick").click(function(e) {
									var date = document.getElementById("hiddendate");
									var week = ['일','월','화','수','목','금','토' ];
									var pickdate = new Date(date.value);
									var dayOfWeek = week[pickdate.getDay()];
									$("#weeklabel").html(dayOfWeek);
									SelectBoxhidden_Ajax();
									
									//달력을 선택하면 
									//groundchange이벤트를 선택할때!
									var gname = $("#ground_name option:selected").val(); //선택되어있는 selectbox
									var checkboxline = document.getElementById("checkboxline");//라디오버튼전체 담아놓은 div
									//날짜 바뀔때마다 "구장" select
									$("#ground_name option:eq(0)").attr("selected", "selected"); 
									//"구장"select를 하면서 셀렉트박스change이벤트호출
									$("#ground_name option:eq(0)").trigger('change');
									//셀렉트옵션 hide후에 다시 모두 show해주기
									 $("#ground_name option").eq(0).show();
									 $("#ground_name option").eq(1).show();
									 $("#ground_name option").eq(2).show();
									 $("#ground_name option").eq(3).show();
									});
						</script>
					</div>
					<hr>
				</div>
				<!-- ---------------------------------------------------------------- -->
				<script>
					function selectAjax(value) {

						$.ajax({
							type : "post",
							url : "./groundselect.do?command=selectground",
							dataType : "json",
							data : {
								ground_name : value,
								branch_no : $("#branch_no").val()
							},
							success : whenSuccesstime,
							error : whenError
						});
					}
					function whenSuccesstime(resdata) {

						var x = document.getElementById("selectajax");

						var clickground_no = resdata[0].clickground_no
						var weekAM_charge = resdata[0].weekAM_charge
						var weekPM_charge = resdata[0].weekPM_charge
						var weekendAM_charge = resdata[0].weekendAM_charge
						var weekendPM_charge = resdata[0].weekendPM_charge
						
						var weekweek = $("label[for='weeklabel']").text();
						if (weekweek == "토") {
							$(".weekAM_charge").html(weekendAM_charge);
							$('.weekAM_charge').val(weekendAM_charge);
							$(".weekPM_charge").html(weekendPM_charge);
							$('.weekPM_charge').val(weekendPM_charge);
						} else if (weekweek == "일") {
							$(".weekAM_charge").html(weekendAM_charge);
							$('.weekAM_charge').val(weekendAM_charge);
							$(".weekPM_charge").html(weekendPM_charge);
							$('.weekPM_charge').val(weekendPM_charge);
						} else {
							$(".weekAM_charge").html(weekAM_charge);
							$('.weekAM_charge').val(weekAM_charge);
							$(".weekPM_charge").html(weekPM_charge);
							$('.weekPM_charge').val(weekPM_charge);
						}
						
						var selectvalue = $(".ground_name").val();
						$("#select_op0").show();
						$("#select_op1").show();
						$("#select_op2").show();
						$("#select_op3").show();
						$("#select_op4").show();
						$("#select_op5").show();
						$("#select_op6").show(); 
						completedData_Ajax(selectvalue);
						
						//ground_name_id hidden 담기
						$('#ground_name_id').val(selectvalue);
						//res_date hidden 담기
						var resdate = $("#hiddendate").val();
						$('#res_date_id').val(resdate);
						///ground_no hidden 담기
						$('#ground_no_id').val(clickground_no);
					}
					function whenError() {
						alert("Error");
					}
				</script>

				<script>
				//예약된날짜의 예약된구장의 예약된시간막기
				function completedData_Ajax(selectvalue) {
						$.ajax({
							type : "post",
							url : "./hiddenradio.do?command=Radiohidden",
							dataType : "json",
							data : {
								ground_name : selectvalue,
								res_date : $("#hiddendate").val(),
								branch_no : $("#branch_no").val()
							},
							success : hiddenSuccesstime,
							error : hiddenError
						});
					}
					function hiddenSuccesstime(resdata) {

						var x = document.getElementById("radioajax");

						var selectvalue = $(".ground_name").val();
						var choicegroundname = $("#ground_name_id").val();
						
						for(var i=0; i<resdata.Dateout.length;i++){
							var completed_time = resdata.Dateout[i].completed_time;
							var choiceground_name = resdata.Dateout[i].choiceground_name;
							
							if (choicegroundname == selectvalue) {
								if(completed_time == "08:00 AM ~ 10:00 AM"){
									$("#select_op0").hide();
								}else if(completed_time == "10:00 AM ~ 12:00 PM"){
									$("#select_op1").hide();
								}else if(completed_time == "12:00 PM ~ 02:00 PM"){
									$("#select_op2").hide();
								}else if(completed_time == "02:00 PM ~ 04:00 PM"){
									$("#select_op3").hide();
								}else if(completed_time == "04:00 PM ~ 06:00 PM"){
									$("#select_op4").hide();
								}else if(completed_time == "06:00 PM ~ 08:00 PM"){
									$("#select_op5").hide();
								}else if(completed_time == "08:00 PM ~ 10:00 PM"){
									$("#select_op6").hide();
								}
							}
						}
					}
					
					function hiddenError() {
					}
				</script>
				<!-- 3번째Ajax : 예약된날짜의 예약된구장의 예약된시간막기 -->
				<script>
				function SelectBoxhidden_Ajax() {

						$.ajax({
							type : "post",
							url : "./hiddenradio.do?command=datepicker_selecthidden",
							dataType : "json",
							data : {
								res_date : $("#hiddendate").val(),
								branch_no : $("#branch_no").val()
							},
							success : SelectBoxhiddenSuccesstime,
							error : SelectBoxhiddenError
						});
					}
					function SelectBoxhiddenSuccesstime(resdata) {

						var x = document.getElementById("selecthiddenajax");
						
						for(var i=0; i<resdata.Datecount.length;i++){
						var choiceground_no = resdata.Datecount[i].choiceground_no;
						var COUNTS = resdata.Datecount[i].COUNTS;
						var choiceground_name = resdata.Datecount[i].choiceground_name;
						if(COUNTS ==7){
							$('#ground_name option[value='+choiceground_name+']').hide();
						}
						}
					}
					function SelectBoxhiddenError() {
					}
				</script>

				<!-- ###################SELECT BOX ######################-->
				<select name="ground_name" class="ground_name" id="ground_name">
					<option value="구장">구장</option>
					<%
						for (int i = 0; i < GroundList.size(); i++) {
					%>
					<option value="<%=GroundList.get(i).getGround_name()%>" style="display:block;"><%=GroundList.get(i).getGround_name()%>(크기:<%=GroundList.get(i).getGround_size()%>)
					</option>
					<%
						}
					%>
				</select>
	 		
				<div class="cont_heg_50"></div>
				<div style="text-align: left; font-size: 17px; margin-top: 36px;"></div>

				<!-- --------------------------------------------------------------------------------------------------------------------------------------- -->
				<!-- Ajax 리턴받는곳 -->
				<div id="selectajax" style="color: red; font-size: 12px;"></div>
				<!-- Ajax2 리턴받는곳 -->
				<div id="radioajax" style="color: red; font-size: 12px;"></div>
				<!-- Ajax3 리턴받는곳 -->
				<div id="selecthiddenajax" style="color: red; font-size: 12px;"></div>

				<div name="checkboxline" id="checkboxline" style="display: none">
					<div class="inputGroup" id="select_op0" style="display: block;" name="radioall">
						<input type="radio" id="option1" class="checkboxsquere" name="check_time" value="08:00 AM ~ 10:00 AM">
						<label for="option1"> 
							<div>08:00 AM ~ 10:00 AM</div>
							<div name="click_charge" class="weekAM_charge" id="weekAM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op1" style="display: block;" name="radioall">
						<input type="radio" id="option2" class="checkboxsquere" name="check_time" value="10:00 AM ~ 12:00 PM">
						<label for="option2"> 
							<div>10:00 AM ~ 12:00 PM</div>
							<div name="click_charge" class="weekAM_charge" id="weekAM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op2" style="display: block;" name="radioall">
						<input type="radio" id="option3" class="checkboxsquere" name="check_time" value="12:00 PM ~ 02:00 PM">
						<label for="option3"> 
							<div>12:00 PM ~ 02:00 PM</div>
							<div name="click_charge" class="weekAM_charge" id="weekAM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op3" style="display: block;" name="radioall">
						<input type="radio" id="option4" class="checkboxsquere" name="check_time" value="02:00 PM ~ 04:00 PM">
						<label for="option4"> 
							<div>02:00 PM ~ 04:00 PM</div>
							<div name="click_charge" class="weekAM_charge" id="weekAM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op4" style="display: block;" name="radioall">
						<input type="radio" id="option5" class="checkboxsquere" name="check_time" value="04:00 PM ~ 06:00 PM">
						<label for="option5"> 
							<div>04:00 PM ~ 06:00 PM</div>
							<div name="click_charge" class="weekAM_charge" id="weekAM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op5" style="display: block;" name="radioall">
						<input type="radio" id="option6" class="checkboxsquere" name="check_time" value="06:00 PM ~ 08:00 PM">
						<label for="option6"> 
							<div>06:00 PM ~ 08:00 PM</div>
							<div name="click_charge" class="weekPM_charge" id="weekPM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
					<div class="inputGroup" id="select_op6" style="display: block;" name="radioall">
						<input type="radio" id="option7" class="checkboxsquere" name="check_time" value="08:00 PM ~ 10:00 PM">
						<label for="option7"> 
							<div>08:00 PM ~ 10:00 PM</div>
							<div name="click_charge" class="weekPM_charge" id="weekPM_charge" value="" style="float:left;margin-left: 422px;"></div>
							<div style="float:left;">(원)</div>
						</label>
					</div>
				</div>
				<!-- --------------------------------------------------------------------------------------------------------------------------------------- -->
				<hr>
				<script>
					//셀렉트박스 change 이벤트
					$(".ground_name").change(function(e) {
					/* function groundchange(mege) { */
						var groundselect = this.value;
						var selectvalue = $(".ground_name").val();//선택한 구장이름
						var weekweek = $("label[for='weeklabel']").text();
						 //선택한 구장순서
						//구장선택에따라 스타일부여(display 보이게/안보이게)
						var checkboxline = document.getElementById("checkboxline");
						if (selectvalue == "구장") { //셀렉트박스 == "구장" ,선택시
							checkboxline.style.setProperty('display', 'none');
						} else { //셀렉트박스 == "A구장" "B구장" "별관"... ,선택시
							selectAjax(groundselect);
							checkboxline.style.removeProperty("display");
							$('input[name="check_time"]').removeAttr('checked'); //이전 셀렉트박스 선택할시 체크했던 라디오버튼 초기화
							$('.checkboxsquere').change(); //합계부분의 text 초기화
						}
					});
				</script>
				<script>
				//라디오버튼 선택 이벤트 ->합계Ajax
						$(".checkboxsquere").change(function(e) {
							if($("input:radio[name='check_time']").is(":checked") == true){ //라디오버튼이 체크되있다면
								var checkclick = this.value; //선택한시간
								var chargename =  $('#'+$(this).attr("id") +' + label div[name="click_charge"]').val(); //선택한가격
								$("#totalcharge").html(checkclick+'  '+chargename+' 원');//합계 div공간에 던져주기
								
								$('#res_time_id').val(checkclick);//시간 hidden에 담기
								$('#res_pay_id').val(chargename); //가격 hidden에 담기
								
							}else{ //라디오버튼이 체크되어있지 않다면
								$("#totalcharge").html(' '); //공백던져주기
							}
						});
				</script>
				
				<div style="text-align: right;font-size: 20px;height: 10px;">
					<div id="totalcharge" style="font-size: 16px;float:right;width: 260px;height: 100%;margin-top: 2px;color:#8e8e8e;">0 원</div>
					<div style="font-size: 18px;float:right;width: 200px;height: 100%;color:#8e8e8e;">합계</div>
				</div>
				 
				<!-- reservation_tb에 넘기기위해 hidden에 담음 -->
				<input type="hidden" name="branch_no" id="branch_no" value="<%=BranchList.get(0).getBranch_no()%>" >
				<input type="hidden" name="ground_no" id="ground_no_id"  value="" >
				
				<input type="hidden" name="id" id="ussid" value="<%=uss%>" >
				<input type="hidden" name="res_date" id="res_date_id" value="" >
				<input type="hidden" name="res_time" id="res_time_id" value="" >
				<input type="hidden" name="payment_charge" id="res_pay_id" value="" >
				<input type="hidden" name="branch_name" id="branch_name_id" value="<%=BranchList.get(0).getBranch_name()%>" >
				<input type="hidden" name="ground_name_id" id="ground_name_id" value="" >
				<%
					}
				%>
			</div>
			<br>
			<hr style="margin-top: 13px;">
			
			<div class="btn_wrap">
			<input type="submit" id="submitbutton" class="btn_big" style="    border: none;" 
			value="결제 " formaction="reservation.do?command=payment_input">
			<input type="submit" class="btn_big gray"  style="    border: none;" 
			value="예약" formaction="reservation.do?command=reservation_input">
			</div>
			</form>
			</div>
		</section>
	</section>
	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
</body>
</html>

