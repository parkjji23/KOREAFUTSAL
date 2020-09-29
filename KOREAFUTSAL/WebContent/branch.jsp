<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	String name = (String) session.getAttribute("name");
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
<title>지점등록</title>
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

<!-- -----------------다음 주소 api ----------------------------------------->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- ------------------------------------------------------------------------- -->
<!-- -------------------------ID 중복확인에 대한 ajax--------------------------------- -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#branch_name").blur(function() {
			var idReg = /^[a-zA-z가-힣]+[a-zA-z0-9가-힣]{2,13}$/;
			var x = document.getElementById("ajaxReturn");
			if (idReg.test(branchjoin.branch_name.value))

				callAjax();
			else {
				x.style.color = "red";
				document.branchjoin.hidden.value = "0";
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
			url : "./branchcheck.do?command=branchcheck",
			data : {

				branch_name : $('#branch_name').val()
			},
			success : whenSuccess,
			error : whenError
		});
	}
	var confirmbranch = "";
	function whenSuccess(resdata) {

		var x = document.getElementById("ajaxReturn");
		$("#ajaxReturn").html(resdata);

		if (resdata.includes("는(은) 이미 사용중인 지점명 입니다")) {
			document.branchjoin.hidden.value = "123";
			x.style.color = "red";
		}

		else {
			document.branchjoin.hidden.value = "0";
			x.style.color = "blue";
			confirmbranch = branchjoin.branch_name.value;

		}
	}
	function whenError() {
		alert("Error");
	}

	//	<!--js 파일 분리가 안돼서 어쩔수없이 이곳에 사용한 용병가입 창 js 파일 2020.01.09-->
	function branchjoins() {

		var branch_namelen = branchjoin.branch_name.value.length
		var address_codelen = branchjoin.address_code.value.length
		var address_basiclen = branchjoin.address_basic.value.length
		var address_detaillen = branchjoin.address_detail.value.length
		var abclen = branchjoin.abc.value.length
		var hiddenlen = branchjoin.hidden.value.length

		if (branch_namelen <= 0) {
			alert("지점명을 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (hiddenlen >= 2) {
			alert("중복된 지점명입니다.");
			branchjoin.branch_name.focus();
		} else if (address_codelen <= 0) {
			alert("우편번호를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (address_basiclen <= 0) {
			alert("기본주소를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (address_detaillen <= 0) {
			alert("상세주소를 입력하세요.");
			branchjoin.branch_name.focus();
		} else if (abclen <= 0) {
			alert("사진 첨부는 필수입니다.");
			branchjoin.branch_name.focus();
		} else {
			document.branchjoin.submit();
		}

	}
</script>



<script>
	$(document).ready(function() {
		var filename = "";
		$("input[type=file]").change(function() {

			var fileInput = document.getElementById("branch_pic");

			var files = fileInput.files;
			var file;

			for (var i = 0; i < files.length; i++) {

				file = files[i];
				filename += file.name;

				//alert( filename);           
			}

			$("#abc").val(filename);
		});
	});
</script>


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
</style>
</head>
<body>

	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft" style="height: 1800px;">


		<div id="leftbanner">
			<div id="banner1">
			<a href="introduce_page.jsp" >
				<img src="img/20191211.jpg" width="100%" height="100%" />
			</a>
			</div>

			<div id="banner3">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.265446899888!2d127.02924799651784!3d37.492391917303266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5bed583f92d%3A0xc93c837d2875ade6!2z7ZKL7IK07J6l!5e0!3m2!1sko!2skr!4v1575961834128!5m2!1sko!2skr"
					width="100%" height="100%" frameborder="0" style="border: 0;"
					allowfullscreen=""></iframe>
			</div>
		</div>


	</div>
	<section id="main">


		<section id="mainright" style="height: 98%;">
			<div id="matList">

				<div class="container" id="formOutterWrapper">
					<center style="font-size:35px;font-weight:bold;letter-spacing:2px;">지점등록</center>
					<div class="container" id="formInnerWrapper">
						<form name="branchjoin" id="branchjoin"
							enctype="multipart/form-data" method="post"
							action="branchinput.do?command=branch">


							<div class="form-group" style="    margin-top: 30px;">
								<div class="col-xs-2"></div>
								<div class="col-xs-4">
									<label class="labels" for="branch_name">지점명</label><input
										type="text" class="formInput" id="branch_name"
										name="branch_name" style="font-size: 18px;">

									<div id="ajaxReturn" style="color: red; font-size: 12px;"></div>
								</div>

								<div class="col-xs-1">
									<label class="labels" for="">연락처</label>
								</div>
								<div class="col-xs-1">
									<select class="formInput" id="tel1" name="tel1">
										<option value="">선택</option>
										<option>02</option>
										<option>031</option>
										<option>051</option>
										<option>053</option>
										<option>032</option>
										<option>062</option>
										<option>042</option>
										<option>052</option>
										<option>044</option>
										<option>033</option>
										<option>043</option>
										<option>041</option>
										<option>063</option>
										<option>061</option>
										<option>054</option>
										<option>055</option>
										<option>064</option>
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
									<label class="labels" for="tel2"></label> <input type="text"
										class="formInput" id="tel2" name="tel2"
										style="font-size: 18px;">
								</div>
								<div style="float: left;">-</div>
								<div class="col-xs-1">
									<label class="labels" for="tel3"></label> <input type="text"
										class="formInput" id="tel3" name="tel3"
										style="font-size: 18px;">
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-2"
									style="font-size: 14px; letter-spacing: 4px; font-weight: 400; width: 182px;">
									<label class="labels">주소<img
										src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif"
										alt="필수"></label>
								</div>

								<div class="col-xs-2">
									<label class="labels" for="address_code"></label> <input
										type="text" id="sample6_postcode" class="formInput"
										id="address_code" name="address_code" placeholder="우편번호"
										readonly>
								</div>
								<div class="col-xs-2">
									<input type="button" value="우편번호 찾기" class="btn btn-default"
										onclick="sample6_execDaumPostcode()">
								</div>
								<div class="col-xs-5"></div>

							</div>
							<div class="form-group">
								<div class="col-xs-4"></div>
								<div class="col-xs-2" style="width: 192px; margin-left: -8px;">
									<label class="labels" for="address_basic"></label> <input
										type="text" class="formInput" id="sample6_address"
										name="address_basic" placeholder="주소" readonly>
								</div>
								<div class="col-xs-4" style="width: 395px;">
									<label class="labels" for="address_detail"></label> <input
										type="text" class="formInput" id="sample6_detailAddress"
										name="address_detail" placeholder="상세주소">
								</div>
							</div>
							<div class="container" id="formOutterWrapper">
							
							<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
							<center style="font-size:35px;    margin-right: 27px;font-weight:bold;letter-spacing:2px;">편의시설</center>


								<div class="form-group" style="    margin-top: 30px;">
									<div class="col-xs-2"></div>
									<div class="col-xs-2">
										<label class="labels">주차장</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="parking"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="parking"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-xs-2"></div>
										<div class="col-xs-2">
										<label class="labels">냉난방시설</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="aircon"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="aircon"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-xs-2"></div>
										<div class="col-xs-2">
										<label class="labels">샤워실</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="shower"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="shower"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-xs-2"></div>
										<div class="col-xs-2">
										<label class="labels">공대여</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="ball"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="ball"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-xs-2"></div>
										<div class="col-xs-2">
										<label class="labels">팀조끼대여</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="vest"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="vest"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-xs-2"></div>
										<div class="col-xs-2">
										<label class="labels">풋살화대여</label>
									</div>
									<div class="col-xs-6 radio">
										<div class="col-xs-5">
											<label2> <input type="radio" name="shoes"
												value="o" checked
												style="text-align: center; font-size: 30px;">보유 </label2>
										</div>
										<div class="col-xs-5">
											<label2> <input type="radio" name="shoes"
												value="x" style="text-align: center; font-size: 30px;">미보유
											</label2>
										</div>
									</div>
								</div>
								


								<div class="form-group">
									<div class="col-xs-2"></div>
									<div class="col-xs-2">
										<label class="labels">사진</label>
									</div>
									<div class="col-xs-3">
										<input type="file" id="branch_pic" name="branch_pic"
										>
									</div>
								</div>

								<div class="form-group">
									<div class="col-xs-4"></div>

								</div>



								<input type="hidden" id="brabchId" name="brabchId" value="<%=logid%>" />
								<input type="hidden" id="name" name="name" value="<%=name%>" />
								<div class="form-group" style="">
									<div class="col-xs-4" style="font-size: 14px;"></div>

									<div class="col-xs-4" style="margin-left: 45px;">

										<input type="button" value="등록" class="signbutton signbutton5"
											onClick="branchjoins()"
											style="font-size: 18px; width: 140px; letter-spacing: 5px;">
										<input type="button" value="취소"
											class="signbutton signbuttoncancel"
											style="font-size: 18px; width: 140px; letter-spacing: 5px;"
											onClick="script: location.href='branch.jsp'">
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



	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
</body>
</html>
