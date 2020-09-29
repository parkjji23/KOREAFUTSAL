<%@page import="model.BranchDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//2020_01_02 수정부분
	String includeurl = "header.jsp";
	String uss = (String) session.getAttribute("id");
	String log = "로그인";
	if (uss == null)
		uss = "GUEST";
	else {
		log = "로그아웃";
		includeurl = "sign_login.jsp";
	}
	//수정부분 끝
	
	//수정사항 2020.01.14 로그인 ID에 대한 정보.
	String logid = (String) session.getAttribute("id");
%>
<%
	ArrayList<BranchDto> branchlist = (ArrayList<BranchDto>)request.getAttribute("branchList");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>yongsign</title>
<!-- datepicker 2020.02.11 지은 수정 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- <link rel='stylesheet' type='text/css' href='http://fian.my.id/Waves/static/waves.min.css?v=0.7.4'> -->
<link rel='stylesheet' type='text/css' href='css/rm-datepicker-mini.css'>
<!-- ---------- -->

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/datepicker.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/common/form_check.js"></script>
<link rel="stylesheet" type="text/css" href="css\join.css" />
<link rel="stylesheet" href="css/classic.css">
<link rel="stylesheet" href="css/classic.date.css">
<link rel="stylesheet" href="css/signbutton.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/signformrelocation.css">
<link rel="stylesheet" href="css/classic.time.css">
<link rel="stylesheet" href="css/style2.css" media="screen">
<link rel="stylesheet" href="css/materialFormStyles2.css">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<script src="js/materialForm.js"></script>



<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
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
<!----------------------------alam form 추가 2020.01.06-------------------------->
<script type="text/javascript">
			$(document).ready(function() {
				$(".mypage").click(function(e) {          
					e.preventDefault();
					$("fieldset#mypage_menu").toggle();
					$(".mypage").toggleClass("menu-open");
				});		
				$("fieldset#mypage_menu").mouseup(function() {
					return false
				});
				$(document).mouseup(function(e) {
					if($(e.target).parent("a.mypage").length!=0) {
						$(".mypage").removeClass("menu-open");
						$("fieldset#mypage_menu").hide();
					}
				});			
				
			});
	</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">
	<!----------------------------회원가입스크립트랑 스타일(따로 빼면 에러)-------------------------->
<script type='text/javascript'>
		$(function() {
		  $('#forgot_username_link').tipsy({gravity: 'w'});   
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
					if($(e.target).parent("a.signin").length==0) {
						$(".signin").removeClass("menu-open");
						$("fieldset#signin_menu").hide();
					}
				});			
				
			});
	</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
<script>
		
	$(function(){
		 var shrinkHeader = 30;
		 var shrinkhollow = 465;
		  $(window).scroll(function() {
			var scroll = getCurrentScroll();
			  if ( scroll >= shrinkHeader ) {
				   $('#navtop').addClass('shrink');  
				}
				else {
					$('#navtop').removeClass('shrink');	
				}
			   if(scroll>= shrinkhollow ){
					$('#navtop').addClass('shrinkhollow');  
				}
				else {
					$('#navtop').removeClass('shrinkhollow');	
				}
	});
	function getCurrentScroll() {
		return window.pageYOffset || document.documentElement.scrollTop;
		}
	});
	</script>
	<!------------------------------ datepicker 2020.02.12 지은수정---------------------------->

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<!-- <script src="http://fian.my.id/Waves/static/waves.min.js?v=0.7.4"></script> -->
<script src="js/rm-datepicker-mini.js"></script>
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
<!-- ---------------------------------------------------------------- -->
<!-- -----------------다음 주소 api ----------------------------------------->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- ------------------------------------------------------------------------- -->
<!-- -------------------------ID 중복확인에 대한 ajax--------------------------------- -->
<script type="text/javascript">
	$(document).ready(function(){
		$("#id").blur(function(){
			var idReg = /^[a-zA-z]+[a-zA-z0-9]{5,13}$/g;
			if(idReg.test(join.id.value))
				callAjax();
			else{
				$("#ajaxReturn").html("6~14자 사이의 영문 대소문자와 숫자만 사용가능합니다");
			}
		});
		$("#name").blur(function(){
			if(join.name.value.length!=0)
				$("#nameReturn").html("");
			else{     
				$("#nameReturn").html("이름을 입력해주세요.");
			}
		});
		
		$("#hp2").blur(function(){
			if(join.hp2.value.length!=0)
				$("#hpReturn").html("");
			else{
				$("#hpReturn").html("휴대폰번호를 입력하세요.");
			}
		});
		$("#hp3").blur(function(){
			if(join.hp3.value.length!=0)
				$("#hpReturn").html("");
			else{
				$("#hpReturn").html("휴대폰번호를 입력하세요.");
			}
		});
		$("#em1").blur(function(){
			if(join.em1.value.length!=0)
				$("#emReturn").html("");
			else{
				$("#emReturn").html("이메일을 입력하세요.");
			}
		});
	});
	
	function callAjax(){
		
		$.ajax({
			type:"post",
		url:"./confirmId.jsp",       
		data:{
	
			id:$('#id').val()
		},	
		success:whenSuccess,
		error:whenError
		});
	}
	var confirmid = "";
	function whenSuccess(resdata){
		
		var x=document.getElementById("ajaxReturn");
		$("#ajaxReturn").html(resdata);
		
		if(resdata.includes("이미 사용중인 ID입니다")){
			document.join.hidden.value="0";
			x.style.color="red";
		}
		
		else{
			document.join.hidden.value="1";
			x.style.color="blue";
			confirmid = join.id.value;
			
			
		}
	}
	function whenError(){
		alert("Error");
	}
	
//	<!--js 파일 분리가 안돼서 어쩔수없이 이곳에 사용한 용병가입 창 js 파일 2020.01.09            + 유효성 검사 2020.01.16 by 종혁형-->
	function yongjoinsubmit()
	{
		
		var getName= (/^[가-힣]+$/);
		var date_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/; 
		var regPhone2= /(\d{3}|\d{4})$/;
		var regPhone3= /(\d{4}$)/;
		var yBranchlen = yongjoin.y_b_branch.value.length
		var yGroundlen = yongjoin.y_b_ground.value.length
		var yMemberlen=yongjoin.y_b_name.value.length
		var yTel1len = yongjoin.y_b_tel1.value.length
		var yTel2len = yongjoin.y_b_tel2.value.length
		var yTel3len = yongjoin.y_b_tel3.value.length
		var yMatchdatelen = yongjoin.y_b_schedule.value.length
		var yTimelen = yongjoin.y_b_time.value.length
		var yApplylen = yongjoin.y_b_status.value.length
		var yTeamlen =yongjoin.y_b_level.value.length
		
		if(yBranchlen<=0){
			alert("지점을 선택하세요.");
			yongjoin.y_b_branch.focus();
			
		}else if(yGroundlen<=0){
			alert("구장을 선택하세요.");
			yongjoin.y_b_ground.focus();
		}else if(yMemberlen<=1||!getName.test(yongjoin.y_b_name.value)){
			alert("이름을 정확히 입력하세요.ex)홍길동");
			yongjoin.y_b_name.focus();
		}else if(yTel1len<=0 ||!regPhone2.test(yongjoin.y_b_tel2.value) ||!regPhone3.test(yongjoin.y_b_tel3.value)){
			alert("전화번호를 입력하세요.ex)010-5555-6666");
			yongjoin.y_b_tel1.focus();
		}else if(!date_pattern.test(yongjoin.y_b_schedule.value)){
			alert("매치일정을 정확히 입력하세요.ex)2020-08-20");
			yongjoin.y_b_schedule.focus();
		}else if(yTimelen<=0){
			alert("시간을 선택하세요.");
			yongjoin.y_b_time.focus();
		}else if(yApplylen<=0){
			alert("마감여부를 선택하세요.");
			yongjoin.y_b_status.focus();
		}else if(yTeamlen<=0){
			alert("팀 수준을 선택하세요.");
			yongjoin.y_b_level.focus();
		}else
		{
			document.yongjoin.submit();
		}

	}
</script>
<!-- 비밀번호 체크 ajax -->
<script type="text/javascript">
function callAjax2(){
	if(join.pw.value!=join.pwch.value){
		$("#pwReturn").html("비밀번호가 일치하지 않습니다");
	}else{
		$("#pwReturn").html("");
	}
}
</script>

<!-- 한글글씨체적용 /아이디찾기 제목-->
<link rel="stylesheet" href="css/galboardstyle.css">
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<style>
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

.write_wrap {
	margin: 0 auto;
	max-width: 800px !important;
	padding: 0 10px;
}

.write_wrap .btn_wrap {
	padding-top: 40px;
	border-top: 2px solid #353535;
}

.btn_wrap {
	margin-top: 20px;
	text-align: center;
	font-size: 0;
	line-height: 0;
}

.btn_big {
	position: relative;
	display: inline-block;
	padding: 0 15px;
	width: 333px;
	background: #2c3c57;
	color: #fff;
	font-size: 23px;
	line-height: 80px;
	text-align: center;
	vertical-align: middle;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-transition: all 0.25s ease-out;
	-moz-transition: all 0.25s ease-out;
	-ms-transition: all 0.25s ease-out;
	-o-transition: all 0.25s ease-out;
	transition: all 0.25s ease-out;
}

.gray {
	background: #868686 !important;
}

.btn_wrap .btn_base, .btn_wrap .btn_big {
	margin-left: 10px;
}

.btn_wrap:after {
	content: "";
	display: block;
	clear: both;
}

.btn_wrap .btn_base:first-child, .btn_wrap .btn_big:first-child {
	margin-left: 0 !important;
}

.write_wrap dl dd input {
	height: 47px;
}

.btn_wrap .btn_base:first-child, .btn_wrap .btn_big:first-child {
	margin-left: 0 !important;
}

a:focus, a:hover {
	color: white;
	text-decoration: underline;
}
</style>



</head>
<body>
	<%//2020_01_22 로그인정보에 따라서 
	if(uss.equals("GUEST")){
		out.println("<script>alert('로그인 후 이용해주시기 바랍니다.');location.href='matyong.do?command=yonglist';</script>");
	
		
	}else{

%>
	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft">


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


		<section id="mainright">
			<div id="matList">

				<div class="container" id="formOutterWrapper">
					<center>
					<h3 class="h_tit" style="font-weight: normal;">용 병 등 록</h3>

					</center>
					<div class="container" id="formInnerWrapper">
						<form name="yongjoin" id="materialForm" class="form" method="post" action="matyong_yongsignInsert.jsp?fn=1&id=<%=uss%>" role="form" autocomplete="off">
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-4">
									<select id="y_b_branch" name="y_b_branch" class=formInput>
											<option value="">지점선택</option>
											<%for(int i=0; i<branchlist.size(); i++){ %>
											<option value=<%=branchlist.get(i).getBranch_no() %>><%=branchlist.get(i).getBranch_name() %></option>
											<%} %>
										</select>
								</div>
								<script>
									$("#y_b_branch").change(function(){
										$.ajax({
											type : "post",
											url : "./matyong.do?command=groundsearchWhbranch",
											dataType : "json",
											data : {
												branch_no : this.value
											},
											success : whenSuccessbranch,
											error : whenErrorbranch
										});
									});
									function whenSuccessbranch(resdata) {
										var groundselectbox = $("#y_b_ground");
										groundselectbox.empty();
										groundselectbox.append("<option value=''>구장선택</option>");
										for(var i=0; i<resdata.groundlist.length;i++){
											groundselectbox.append("<option value='"+resdata.groundlist[i].ground_no+"'>"+resdata.groundlist[i].ground_name+"</option>");
										}
									}
									function whenErrorbranch() {
										alert("등록된 구장이 없습니다.");
										var groundselectbox = $("#y_b_ground");
										groundselectbox.empty();
										groundselectbox.append("<option value=''>구장선택</option>");
									}
									</script>
								<div class="col-xs-4">
									<select name="y_b_ground" id="y_b_ground" class=formInput>
										<option value="">구장선택</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-4">
									<label class="labels" for="y_b_name">신청자명</label> <input type="text" class="formInput" id="y_b_name" name="y_b_name" style="font-size:18px;">
								</div>
								<div class="col-xs-1">
									<label class="labels" for="">연락처</label>
									</div>
								<div class="col-xs-1">
									<select class="formInput" id="y_b_tel1" name="y_b_tel1">
										<option value="">선택</option>
										<option>010</option>
										<option>011</option>
										<option>016</option>
										<option>017</option>
										<option>018</option>
										<option>019</option>
									</select>
								</div>
								<div style="float: left;">-</div>
								<div class="col-xs-1">
									<label class="labels" for="y_b_tel2"></label>
									 <input type="text" class="formInput" id="y_b_tel2" name="y_b_tel2" style="font-size:18px;">
								</div>
								<div style="float: left;">-</div>
								<div class="col-xs-1">
									<label class="labels" for="y_b_tel3"></label> <input type="text" class="formInput" id="y_b_tel3" name="y_b_tel3" style="font-size:18px;">
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-1" style="font-size:18px; width:120px; letter-spacing:4px;">
								매치일정
								</div>
								<div class="col-xs-3">
								<div ng-app="myApp" ng-controller="MyCtrl" class="container">
										<input rm-datepicker type="text" ng-model="oDate2" rm-config="rmConfig1"
											id="y_b_schedule" name="y_b_schedule"
											style="width: 233px; margin-left: -21px; height: 27px; margin-top: -1px; font-size: 17px;">
										<br>
										<br>
										<br>
									</div>
								</div>
								<div class="col-xs-4" style="margin-left:-25px;">
									<select class="formInput" id="y_b_time" name="y_b_time">
										<option value="">시간선택</option>
										<option>13:00 - 15:00</option>
										<option>16:00 - 18:00</option>
										<option>18:00 - 20:00</option>
										<option>20:00 - 22:00</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-4">
									<select name="y_b_status" id="y_b_status" class=formInput>
										<option value="">마감여부</option>
										<option>가능</option>
										
									</select>
								</div>
								<div class="col-xs-4">
									<select name="y_b_level" id="y_b_level" class=formInput>
										<option value="">팀수준선택</option>
										<option>상</option>
										<option>중상</option>
										<option>중</option>
										<option>중하</option>
										<option>하</option>
									</select>
								</div>
							</div>
							<div class="form-group" style="height:284px;">
								<div class="col-xs-2"></div>
								<div class="col-xs-4">
									<label class="labels" for="y_b_contents"></label>
									<textarea name="y_b_contents" id="y_b_contents" style="width:730px;resize:none; height:200px;" placeholder="내용을 입력하세요." ></textarea>
								</div>
								
							</div>
							
							
							
							
							
							
							
							




							<input type="hidden" id="id" name="id" value="<%=logid%>" />
							<div class="btn_wrap" style="margin-bottom: 100px;">
								<a href="javascript:;" class="btn_big"
									onClick="yongjoinsubmit()";>등록하기</a> <a
									href="matyong.do?command=yonglist" class="btn_big gray">취소</a>
							</div>
							

						</form>
					</div>
				</div>
				<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
				<script src="js/materialForm.js"></script>
			</div>

		</section>


	</section>



	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
	<%} %>
</body>
</html>
