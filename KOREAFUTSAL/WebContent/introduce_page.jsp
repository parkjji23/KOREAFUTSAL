<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String uss = "GUEST";
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>KOREA FUTSAL INTRODUCE</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/datepicker.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/common/form_check.js"></script>
<link rel="stylesheet" type="text/css" href="css\find.css" />
<link rel="stylesheet" href="css/signbutton.css">
<link rel="stylesheet" href="css/find.css">
<link rel="stylesheet" href="css/classic.css">
<link rel="stylesheet" href="css/classic.date.css">
<link rel="stylesheet" href="css/classic.time.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/style2.css" media="screen">
<link rel="stylesheet" href="css/findid_materialFormStyles.css">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<script src="js/materialForm.js"></script>
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>
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
		/* $(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}
		}); */
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
<style>
.form-group {
	height: 70px;
}

.form-group input {
	float: left;
}
</style>
<!-- 한글글씨체적용 /아이디찾기 제목-->
<link rel="stylesheet" href="css/galboardstyle.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
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
font-weight:bold;
}
</style>
<style>
.checkicon{
font-family: 'Font Awesome 5 Pro';
font-weight: 900;
}
.info-text{
    color: #295cff;
    font-weight:bold;
}

.fa-check-circle:before {
    content: "\f058";
}
.creators_div{
font-size:18px;
color:gray;
letter-spacing:2px;
word-spacing:2px;
}

.creators_name{
font-size:25px;
LETTER-SPACING:2PX;
}
</style>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<!-- ---------------------------------------------------------------------------------------------- -->
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	<div id="mainleft">


		<div id="leftbanner">
			<div id="banner1">
				<a href="introduce_page.jsp" >
					<img src="img/20191211.jpg" width="100%" height="100%" />
				</a>
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
				
				
				
				<div class="introduce">
				<div class="info-text" STYLE="FONT-SIZE:15PX;TEXT-ALIGN:CENTER;">
				<i class="fas fa-check-circle"></i>
				KOREA FUTSAL은 사람들이 보다 쉽게 풋살을 즐기기 위한 서비스로 장소 대관뿐만 아니라 팀별 리그개최로  풋살경기가 활성화 될 수 있도록 커뮤니티 서비스를 활성화 하였습니다
				</div>
				
				<div style="text-align:center;MARGIN-TOP: 60PX;"><img src="img/KOREAFUTSAL_INTRODUCE.jpg"></div>
				
				<div style="float:left;MARGIN-TOP: 30PX;    MARGIN-BOTTOM: 30PX;">
				<img src="img/introduce6.jpg" style="margin-left: 8px;margin-bottom: 7px;">
				<img src="img/introduce5.jpg" style="margin-left: 12px;">
				<img src="img/introduce4.jpg" style="margin-left: 14px;    margin-top: 12px;}">
				</div>
				
				<div>
				<center style="font-size:50px;">CREATORS</center>
				<ul class="creators_ul" STYLE="    MARGIN-TOP: 50PX;">
				<div><img src="img/introduce7.png" style="width:210px;height:210px;float:left;"></div>
				<li class="creators_name" style="    padding-top: 40px;    PADDING-BOTTOM: 7PX;">KIM KWANG-HO</li>
				<li class="creators_div">기획<br/>검색/로그인유지/Q&A<br/>팀커뮤니티/팀리스트<br/>팀신청/팀관리<br/></li>
				
				<div><img src="img/introduce8.png" style="float:right;width:210px;height:210px;"></div>
				<li class="creators_name" style="text-align:right;MARGIN-TOP: 35PX;PADDING-BOTTOM: 11PX;">PARK JI-EUN</li>
				<li class="creators_div" style="text-align:right;">대관/예약내역 관리<br/>풋살장 리스트/상세보기<br/>마이페이지/퀵바<br/>ID/PASSWORD 찾기<br/></li>
				
				<div><img src="img/introduce9.png" style="width:210px;height:210px;float:left;"></div>
				<li class="creators_name" STYLE="    MARGIN-TOP: 22PX;PADDING-BOTTOM: 2PX;">LEE JONG-HYEOK</li>
				<li class="creators_div">총관리<br/>지도 Index<br/>팀갤러리 게시판/댓글<br/>리그 신청<br/>게시물팝업<br/></li>		
				
				<div><img src="img/introduce10.png" style="float:right;width:210px;height:210px;"></div>
				<li class="creators_name" style="text-align:right;    MARGIN-TOP: 22PX;PADDING-BOTTOM: 2PX;">JUNG MOON-GYUNG</li>
				<li class="creators_div" style="text-align:right;">관리자 페이지<br/>회원정보/사업자정보 관리<br/>리그랭킹 관리<br/>지점/구장 등록<br/>공지사항<br/></li>
				</ul>
				</div>
				
				<div STYLE="MARGIN-TOP:100PX;">
				<div style="padding-left: 69px;padding-top: 35px;text-align: center;width: 100%;height:390px;border: 1px solid #e0e0e0;float:left;    MARGIN-BOTTOM: 100PX;">
				<div style="float:left;">
				<img src="img/introduce1.jpg" style="width:255px;height:255px;">
				<div style="margin-top:20px;">대관하고자 하는 풋살장의 정보를<br/>한눈에 확인할 수 있게하고<br/><span style="color:#295cff;">커뮤니티</span>로서의 기능을 강조
				</div>
				</div>
				<div style="float:left;padding-left: 130px;">
				<img src="img/introduce2.png" style="width:255px;height:255px;">
				<div style="margin-top:20px;">등록된 풋살장의 위치를<br/><span style="color:#295cff;">홈페이지 메인지도</span>에 띄워 안내함으로써<br/>사용자의 접근성을 높임
				</div>
				</div>
				<div style="float:left;padding-left: 130px;">
				<img src="img/introduce3.jpg" style="width:255px;height:255px;">
				<div style="margin-top:20px;"> 홈페이지의 이용자분들을<br/><span style="color:#295cff;">일반회원</span>과 <span style="color:#295cff;">사업자</span>로 구분하고<br/>서로 다른 서비스를 제공
				</div>
				</div>
				</div>
				</div>
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
</body>
</html>
