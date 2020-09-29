<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.BranchDto"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) request.getAttribute("BranchList");
    String branch_name = request.getParameter("branch_name");
    String branch_no = request.getParameter("branch_no");
    
%>

<%
	String url = request.getServletPath();
	session.setAttribute("url", url);
	String includeurl = "adminH.jsp";
	String logid = (String) session.getAttribute("admin_id");
	//out.println(uss);
	String log = "로그인";
	if (logid == null)
		logid = "GUEST";
	else {
		log = "로그아웃";
		includeurl = "adminH.jsp";
	}
	//수정부분 끝
%>
    
    <%
	
	
	String admin_id = (String) session.getAttribute("admin_id");

%>
<!-- datepicker -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- <link rel='stylesheet' type='text/css' href='http://fian.my.id/Waves/static/waves.min.css?v=0.7.4'> -->
<link rel='stylesheet' type='text/css' href='css/rm-datepicker.css'>
<!-- ---------- -->
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>yongsign</title>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
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
		/* $(document).mouseup(function(e) {
			if ($(e.target).parent("a.mypage").length != 0) {
				$(".mypage").removeClass("menu-open");
				$("fieldset#mypage_menu").hide();
			}
		}); */

	});
</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
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
<link href="css/front.css" media="screen, projection" rel="stylesheet"
	type="text/css">
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
<script>

</script>
<!------------------------------ datepicker ---------------------------->

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<!-- <script src="http://fian.my.id/Waves/static/waves.min.js?v=0.7.4"></script> -->
<script src="js/rm-datepicker.js"></script>
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
				min : new Date('2000-11-21'),
				max : new Date('2023-11-21'),
				format : "yyyy-MM-dd" /* https://docs.angularjs.org/api/ng/filter/date */
			};

			$scope.oDate1 = new Date('2015-12-12');
			$scope.oDate2 = new Date();
		};
		app.controller("MyCtrl", [ '$scope', MyCtrl ]);

	}());

	// Init waves (OPTIONAL) :)
	// window.onload = Waves.init();
</script>
<!-- ---------------------------------------------------------------- -->
<!-- -----------------다음 주소 api ----------------------------------------->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- ------------------------------------------------------------------------- -->
<!-- -------------------------ID 중복확인에 대한 ajax--------------------------------- -->


<script type="text/javascript">
	$(document).ready(function() {
		$("#ground_name").blur(function() {
			var idReg = /^[a-zA-z가-힣]+[a-zA-z0-9가-힣]{2,13}$/g;
			var x = document.getElementById("ajaxReturn");
			if (idReg.test(groundjoin.ground_name.value))

				callAjax();
			else {
				document.groundjoin.hidden.value = "0";
				x.style.color = "red";
				$("#ajaxReturn").html("3~14자 사이만 사용가능합니다");

			}
		});
		
		var n = document.getElementById("nameReturn");
		$("#name").blur(function() {
			if (join.name.value.length != 0)
				$("#nameReturn").html("");
			else {
				$("#nameReturn").html("이름을 입력해주세요.");
				n.style.color = "red";
			}
		});

		$("#tel2").blur(function() {
			if (join.hp2.value.length != 0)
				$("#hpReturn").html("");
			else {
				$("#hpReturn").html("휴대폰번호를 입력하세요.");
			}
		});
		$("#tel3").blur(function() {
			if (join.hp3.value.length != 0)
				$("#hpReturn").html("");
			else {
				$("#hpReturn").html("휴대폰번호를 입력하세요.");
			}
		});
		$("#email1").blur(function() {
			if (join.em1.value.length != 0)
				$("#emReturn").html("");
			else {
				$("#emReturn").html("이메일을 입력하세요.");
			}
		});
	});

	function callAjax() {

		$.ajax({
			type : "post",
			url : "./groundcheck.do?command=groundcheck",
			data : {

				ground_name : $('#ground_name').val()
			},
			success : whenSuccess,
			error : whenError
		});
	}
	

	var confirmbranch = "";
	function whenSuccess(resdata) {
	
		var x = document.getElementById("ajaxReturn");
		$("#ajaxReturn").html(resdata);

		if (resdata.includes("이미 사용중인 구장명 입니다")) {
		     
			document.groundjoin.hidden.value = "123";
			
		
			x.style.color = "red";
		}

		else {
			document.groundjoin.hidden.value = "0";
		
			x.style.color = "blue";
		
			confirmbranch = branchjoin.branch_name.value;

		}
		
	}
	function whenError() {
		alert("Error");
	}

	//	<!--js 파일 분리가 안돼서 어쩔수없이 이곳에 사용한 용병가입 창 js 파일 2020.01.09-->
	function groundjoins() {

		var ground_namelen = groundjoin.ground_name.value.length
		var ground_size_1len = groundjoin.ground_size_1.value.length
		var ground_size_2len = groundjoin.ground_size_2.value.length
		var ground_weekdaydaytime_charge = groundjoin.ground_weekdaydaytime_charge.value.length
		var ground_weekdaynight_chargelen = groundjoin.ground_weekdaynight_charge.value.length
		var ground_weekenddaytime_chargelen = groundjoin.ground_weekenddaytime_charge.value.length
		var ground_weekendnight_chargelen = groundjoin.ground_weekendnight_charge.value.length

		var abclen = groundjoin.abc.value.length
		var hiddenlen = groundjoin.hidden.value.length

		if (ground_namelen <= 0) {
			alert("구장명을 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (hiddenlen >= 2) {
			alert("중복된 구장명입니다.");
			branchjoin.branch_name.focus();
		} else if (ground_size_1len <= 0) {
			alert("구장크기를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (ground_size_2len <= 0) {
			alert("구장크기를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (ground_weekdaydaytime_charge <= 0) {
			alert("주중주간요금를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (ground_weekdaynight_chargelen <= 0) {
			alert("주중야간요금를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (ground_weekenddaytime_chargelen <= 0) {
			alert("주말주간를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (ground_weekendnight_chargelen <= 0) {
			alert("주말야간를 입력하세요.");
			branchjoin.branch_name.focus();
		}  else {
			document.groundjoin.submit();
		}

	}
</script>



<script>
	$(document).ready(function() {
		var filename = "";
		$("input[type=file]").change(function() {

			var fileInput = document.getElementById("ground_pic");

			var files = fileInput.files;
			var file;

			for (var i = 0; i < files.length; i++) {

				file = files[i];
				filename += file.name + ",";

			}
			alert(filename);
			$("#abc").val(filename);
		});
	});
</script>


<!-- 한글글씨체적용 /아이디찾기 제목-->
<link rel="stylesheet" href="css/galboardstyle.css">
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
</head>
<body>

	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft" style="height: 800px;margin-right: 6px;">


		<div id="leftbanner">
	


		</div>


	</div>
	<section id="main">


		<section id="mainright" style="height: 90%;">
			<div id="matList">

				<div class="container" id="formOutterWrapper">
					<center>
						<div class="writeboardtitle"
							style="text-align: center; font-size: 50px;">구장 등록</div>

					</center>
					<div class="container" id="formInnerWrapper">
						<form name="groundjoin" id="groundjoin"
							enctype="multipart/form-data" method="post"
							action="groundinput.adm?command=ground&branch_no=<%=branch_no%>">


							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-2" style="width: 100px;">
									<label class="labels">지점명</label>
								</div>
								<div class="col-xs-7">
									<label class="labels" id="branch_name" name="branch_name"><%=branch_name%>
									</label>


								</div>
							</div>
							
							
						
							




							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-8">
									<label class="labels" for="ground_name">구장명</label><input
										type="text" class="formInput" id="ground_name"
										name="ground_name" style="font-size: 18px;">

									<div id="ajaxReturn" style="color: red; font-size: 12px;"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>

								<div class="col-xs-2">
									<label class="labels" for="">구장 크기</label>
								</div>


								<div class="col-xs-1">
									<label class="labels" for="ground_size_1"></label> <input
										type="text" class="formInput" id="ground_size_1"
										name="ground_size_1" style="font-size: 18px;">
								</div>
								<div style="float: left;">*</div>
								<div class="col-xs-1">
									<label class="labels" for="ground_size_2"></label> <input
										type="text" class="formInput" id="ground_size_2"
										name="ground_size_2" style="font-size: 18px;">
								</div>
								<div class="col-xs-2">
									<label class="labels" for="">구장 위치</label>
								</div>
								<div class="col-xs-2">
									
									<select class="formInput" id="ground_field" name="ground_field">
										<option value="실내">실내</option>
										<option value="실외">실외</option>
									</select>
							
									
								
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-8">
									<label class="labels" for="ground_weekdaydaytime_charge">주중
										주간요금</label><input type="text" class="formInput"
										id="ground_weekdaydaytime_charge"
										name="ground_weekdaydaytime_charge"
										style="font-size: 18px; text-align: right;">


								</div>
								<div style="font-size: 18px;">원</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-8">
									<label class="labels" for="ground_weekdaynight_charge">주중
										야간요금</label><input type="text" class="formInput"
										id="ground_weekdaynight_charge"
										name="ground_weekdaynight_charge"
										style="font-size: 18px; text-align: right;">


								</div>
								<div style="font-size: 18px;">원</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-8">
									<label class="labels" for="ground_weekenddaytime_charge">주말
										주간요금</label><input type="text" class="formInput"
										id="ground_weekenddaytime_charge"
										name=ground_weekenddaytime_charge
										style="font-size: 18px; text-align: right;">


								</div>
								<div style="font-size: 18px;">원</div>
							</div>
							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-8">
									<label class="labels" for="ground_weekendnight_charge">주말
										야간요금</label><input type="text" class="formInput"
										id="ground_weekendnight_charge"
										name="ground_weekendnight_charge"
										style="font-size: 18px; text-align: right;">


								</div>
								<div style="font-size: 18px;">원</div>
							</div>







							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-2">
									<label class="labels">사진</label>
								</div>
								<div class="col-xs-3">
									<input type="file" id="ground_pic" name="ground_pic"
										multiple="multiple">
								</div>
							</div>



							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-2" style="width: 130px;">
									<label class="labels">안내사항 </label>
								</div>
								<div class="col-xs-6">
									<textarea id="ground_rule" name="ground_rule"
										class="form-control" rows="7"
										style="resize: none; width: 600px;"></textarea>
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-10"></div>

							</div>

							<div class="form-group">
								<div class="col-xs-10"></div>

							</div>






							<input type="hidden" id="yId" name="yId" value="<%=logid%>" />
							<input type="hidden" id="branch_no" name="branch_no" value="<%=branch_no%>" />
							<div class="form-group" style="">
								<div class="col-xs-4" style="font-size: 14px;"></div>

								<div class="col-xs-4" style="margin-left: 45px;">

									<input type="button" value="등록" class="signbutton signbutton5"
										onClick="groundjoins()"
										style="font-size: 18px; width: 140px; letter-spacing: 5px;">
									<input type="button" value="취소"
										class="signbutton signbuttoncancel"
										style="font-size: 18px; width: 140px; letter-spacing: 5px;"
										onClick="location.href='admin_BranchList_view.adm?command=admin_BranchList_view&branch_no=<%=branch_no%>'">
								</div>


							</div>



							<input type="hidden" id="abc" name="abc"> <input
								type="hidden" id="hidden" name="hidden">
						</form>
					</div>
				</div>
				<script src="https://code.jquery.com/jquery-2.2.3.min.js"
					integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
					crossorigin="anonymous"></script>
				<script src="js/materialForm.js"></script>
			</div>

		</section>


	</section>




</body>
</html>
