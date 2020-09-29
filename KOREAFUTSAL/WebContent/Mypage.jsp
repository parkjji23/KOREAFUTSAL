<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	//2020_01_02 수정부분
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
	//수정부분 끝
%>

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
<!-- 로그아웃 상태로 마이페이지 가는것 막기 ************-->
<%
	if (uss == "GUEST") {
%>
<script>
	alert("로그인 후 이용해주세요");
	location.href="index.do?command=index";
</script>
<%
	}
%>
<!-- ************************************ -->
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<link rel="stylesheet" type="text/css" href="css\join.css" />
<link rel="stylesheet" href="css/classic.css">
<link rel="stylesheet" href="css/classic.date.css">
<link rel="stylesheet" href="css/classic.time.css">
<link rel="stylesheet" href="css/style2.css" media="screen">
<link rel="stylesheet" href="css/materialFormStyles.css">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<script src="js/materialForm.js"></script>
<link rel="stylesheet" href="css/signbutton.css">


<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>


<title>마이페이지</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/datepicker.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/common/form_check.js"></script>
<link rel="stylesheet" type="text/css" href="css\join.css" />
<link rel="stylesheet" href="css/Mypage.css">
<link rel="stylesheet" href="css/classic.css">
<link rel="stylesheet" href="css/classic.date.css">
<link rel="stylesheet" href="css/classic.time.css">
<link rel="stylesheet" href="css/style2.css" media="screen">
<link rel="stylesheet" href="css/materialFormStyles.css">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<script src="js/materialForm.js"></script>
<link rel="stylesheet" href="css/signbutton.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/galboardstyle.css">

<!-- -----------------다음 주소 api ----------------------------------------->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>

<!----------------------------alam form 추가 2020.01.06-------------------------->
<!----------------------------alam form 추가 2020.01.06-------------------------->

<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
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
<link href="css/frontlogin.css" media="screen, projection" rel="stylesheet" type="text/css">
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
			if ($(e.target).parent("a.mypage").length == 0) {
				$(".mypage").removeClass("menu-open");
				$("fieldset#mypage_menu").hide();
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

<TITLE>마이페이지</TITLE>
<style>
#my_frame {
	margin-left: -105px;
	width: 1300px;
	height: 1600px;
	overflow: hidden;
	overflow-x: hidden;
	overflow-y: hidden;
	cursor: pointer;
	border: 1px solid rgba(0, 0, 0, 0.1);
}

</style>

<script src="//code.jquery.com/jquery.min.js"></script>
<!-- 메뉴클릭 : 메뉴버튼색상변경, 아이프레임 링크삽입 -->
<script>
	function open_in_frame1(url) {
		var clickmenu1 = document.getElementById("clickmenu1");
		var clickmenu2 = document.getElementById("clickmenu2");
		var clickmenu3 = document.getElementById("clickmenu3");
		var clickmenu4 = document.getElementById("clickmenu4");
		var clickmenu5 = document.getElementById("clickmenu5");
		$('#my_frame').attr('src', url);
		clickmenu1.style.removeProperty("background");
		clickmenu2.style.removeProperty("background");
		clickmenu3.style.removeProperty("background");
		clickmenu4.style.removeProperty("background");
		clickmenu5.style.removeProperty("background");
		clickmenu1.style.setProperty('background', '#e5e5e5');
	}
	function open_in_frame2(url) {
		var clickmenu1 = document.getElementById("clickmenu1");
		var clickmenu2 = document.getElementById("clickmenu2");
		var clickmenu3 = document.getElementById("clickmenu3");
		var clickmenu4 = document.getElementById("clickmenu4");
		var clickmenu5 = document.getElementById("clickmenu5");
		$('#my_frame').attr('src', url);
		clickmenu1.style.removeProperty("background");
		clickmenu2.style.removeProperty("background");
		clickmenu3.style.removeProperty("background");
		clickmenu4.style.removeProperty("background");
		clickmenu5.style.removeProperty("background");
		clickmenu2.style.setProperty('background', '#e5e5e5');
	}
	function open_in_frame3(url) {
		var clickmenu1 = document.getElementById("clickmenu1");
		var clickmenu2 = document.getElementById("clickmenu2");
		var clickmenu3 = document.getElementById("clickmenu3");
		var clickmenu4 = document.getElementById("clickmenu4");
		var clickmenu5 = document.getElementById("clickmenu5");
		$('#my_frame').attr('src', url);
		clickmenu1.style.removeProperty("background");
		clickmenu2.style.removeProperty("background");
		clickmenu3.style.removeProperty("background");
		clickmenu4.style.removeProperty("background");
		clickmenu5.style.removeProperty("background");
		clickmenu3.style.setProperty('background', '#e5e5e5');
	}
	function open_in_frame4(url) {
		var clickmenu1 = document.getElementById("clickmenu1");
		var clickmenu2 = document.getElementById("clickmenu2");
		var clickmenu3 = document.getElementById("clickmenu3");
		var clickmenu4 = document.getElementById("clickmenu4");
		var clickmenu5 = document.getElementById("clickmenu5");
		$('#my_frame').attr('src', url);
		clickmenu1.style.removeProperty("background");
		clickmenu2.style.removeProperty("background");
		clickmenu3.style.removeProperty("background");
		clickmenu4.style.removeProperty("background");
		clickmenu5.style.removeProperty("background");
		clickmenu4.style.setProperty('background', '#e5e5e5');
	}
	function open_in_frame5(url) {
		var clickmenu1 = document.getElementById("clickmenu1");
		var clickmenu2 = document.getElementById("clickmenu2");
		var clickmenu3 = document.getElementById("clickmenu3");
		var clickmenu4 = document.getElementById("clickmenu4");
		var clickmenu5 = document.getElementById("clickmenu5");
		$('#my_frame').attr('src', url);
		clickmenu1.style.removeProperty("background");
		clickmenu2.style.removeProperty("background");
		clickmenu3.style.removeProperty("background");
		clickmenu4.style.removeProperty("background");
		clickmenu5.style.removeProperty("background");
		clickmenu5.style.setProperty('background', '#e5e5e5');
	}
	
</script>
<script>
window.onload = function () {
	var clickmenu1 = document.getElementById("clickmenu1");
	clickmenu1.click(); 
}
</script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
p {
	margin: 20px 0px;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>

	<section id="main">
		<section id="mainright" style="height: 180%;">
			<div id="matList">
				<div class="container" id="formOutterWrapper">
					<center>
						<div style="font-size: 40px;font-weight: bold;    margin-left: 126px;">${id}'sMypage</div>
					</center>
					<div class="container">
						<div class="row">
							<div class="col" style="    margin-top: 100px;">
								<ul class="nav nav-tabs" style="margin-bottom: -47px; border-bottom: none; margin-left: -120px;">
									<li class="nav-item" style="font-weight:bold;"><button id="clickmenu1" style="" 
									class="nav-link active" onclick='open_in_frame1("mypage.do?command=reservation_list&id=${id}")'>대관내역</button></li>
									<li class="nav-item" style="font-weight:bold;"><button id="clickmenu2" name="focusmenu" style="" 
									class="nav-link active" onclick='open_in_frame2("mypage.do?command=mypage&id=${id}")'>회원정보수정</button></li>
									<li class="nav-item" style="font-weight:bold;"><button id="clickmenu3" style="" 
									class="nav-link active" onclick='open_in_frame3("mypage.do?command=mypageteam_click&id=${id}")'>팀정보</button></li>
									<li class="nav-item" style="font-weight:bold;"><button id="clickmenu4" style="" 
									class="nav-link active" onclick='open_in_frame4("mypage.do?command=mypageleague_click&id=${id}")'>리그정보</button></li>
									<li class="nav-item" style="font-weight:bold;"><button id="clickmenu5" style="" 
									class="nav-link active" onclick='open_in_frame5("signdel.jsp")'>회원탈퇴</button></li>
								</ul>
							</div>
						</div>
					</div>
					<iframe id='my_frame' style="margin-top: -16px;"></iframe>
					</center>
					<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous">
						
					</script>
					<script src="js/materialForm.js">
						
					</script>
		</section>
	</section>
	<footer>
		<jsp:include page="Footer.jsp" />
	</footer>

</body>
</html>