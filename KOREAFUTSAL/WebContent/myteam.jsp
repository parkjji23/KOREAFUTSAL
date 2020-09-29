<%@page import="model.TeamDto"%>
<%@page import="model.GroundDto"%>
<%@page import="model.BranchDto"%>
<%@page import="model.ReservationDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	ArrayList<TeamDto> myteamlist = (ArrayList<TeamDto>) request.getAttribute("myteamlist");
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
<!doctype html>
<html lang="en" style="overflow-y: hidden; overflow-x: hidden;">
<!-- iframe들어가는 박스에 스크롤 안생기게 -->
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>팀게시판</title>
<link rel="stylesheet" href="css/galboardstyle.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/signbutton.css">
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
<!--Q&A에 펠요한 css-->
<link rel="stylesheet" href="css/Q&Astyle.css" media="screen">
<!-- Q&A에 필요한 script -->
<script type="text/javascript" src="Q&Ascript.js"></script>

<!--주메뉴밑줄기능-->
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<!-- 광호Q&A -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<link rel="stylesheet" href="css/galstyle.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">
<!--배너2 자동슬라이드-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>
<!--footer css 파일 추가-->
<link rel="stylesheet" href="css/footer.css">

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
				//console.log($(e.target).parent("a.mypage").length);

			}
		});

	});
</script>
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
			if ($(e.target).parent("a.mypage").length == 0) {
				$(".mypage").removeClass("menu-open");
				$("fieldset#mypage_menu").hide();
				console.log($(e.target).parent("a.signin").length);
			}
		});

	});
</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
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
<!--2020.03.24 게시판 css추가 -->
<link rel="stylesheet" href="css/boardstyle.css">

<style>
#reservationtable {
	border: 1px solid #444444;
	margin-left: -260px;
	font-size: 17px;
	text-align: center;
}

.td_divstyle {
	width: 149px;
	float: left;
	text-align: center;
	border: 1px solid #444444;
	height: 45px;
}

.restb {
	text-align: center;
	border: 1px solid #444444;
	height: 45px;
	width: 150px;
	float: left;
}
/* 표큰테두리스타일 */
#tablediv {
	width: 1230px;
	height: 1350px;
	margin-left: -319px;
}

.td_1_title {
	width: 130px;
	float: left;
	text-align: center;
	height: 50px;
}

.td_1 {
	font-size: 16px;
	font-weight: 700;
	color: white;
	width: 130px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 14px;
	border-bottom: 1px solid #d5d8dd;
}

.td_2_3_title {
	width: 150px;
	float: left;
	text-align: center;
	height: 50px;
}

.td_2_3 {
	font-size: 16px;
	font-weight: 700;
	color: #777;
	width: 150px;
	float: left;
	text-align: center;
	border-bottom: 1px solid #d5d8dd;
	height: 50px;
	padding-top: 14px;
}

.td_4_6_title {
	width: 149px;
	float: left;
	text-align: center;
	height: 50px;
}

.td_4_6 {
	font-size: 16px;
	font-weight: 700;
	color: #777;
	text-align: center;
	border-bottom: 1px solid #d5d8dd;
	height: 50px;
	width: 150px;
	float: left;
	padding-top: 14px;
}

.td_5_title {
	width: 200px;
	float: left;
	text-align: center;
	height: 50px;
}

.td_5 {
	font-size: 16px;
	font-weight: 700;
	color: #777;
	width: 200px;
	float: left;
	text-align: center;
	border-bottom: 1px solid #d5d8dd;
	height: 50px;
	padding-top: 14px;
}

.td_7_title {
	width: 230px;
	float: left;
	text-align: center;
	height: 50px;
}

.td_7 {
	font-size: 16px;
	font-weight: 700;
	color: #777;
	width: 230px;
	float: left;
	text-align: center;
	border-bottom: 1px solid #d5d8dd;
	height: 50px;
	padding-top: 14px;
}

.td_7_button {
	width: 230px;
	float: left;
	text-align: center;
	border-bottom: 1px solid #d5d8dd;
	height: 50px;
	padding-top: 4px;
}

.paybutton {
	background-color: #4c89cd;
	color: white;
	width: 107px;
	height: 40px;
	border: 1px solid #4440;
	font-size: 16px;
	letter-spacing: 7px;
	height: 48px;
}

.cancelbutton {
	background-color: #fff;
	color: #777;
	width: 107px;
	height: 40px;
	border: 1px solid #4440;
	font-size: 16px;
}

.td_1_realtitle {
	width: 130px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 10px;
	border-top: 2px solid #2c3c57;
	border-bottom: 2px solid #2c3c57;
	background: #fff;
	color: #4d4d4d;
	font-size: 18px;
}

.td_2_3_realtitle {
	width: 150px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 10px;
	border-top: 2px solid #2c3c57;
	border-bottom: 2px solid #2c3c57;
	background: #fff;
	color: #4d4d4d;
	font-size: 18px;
}

.td_4_6_realtitle {
	width: 149px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 10px;
	border-top: 2px solid #2c3c57;
	border-bottom: 2px solid #2c3c57;
	background: #fff;
	color: #4d4d4d;
	font-size: 18px;
}

.td_5_realtitle {
	width: 200px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 10px;
	border-top: 2px solid #2c3c57;
	border-bottom: 2px solid #2c3c57;
	background: #fff;
	color: #4d4d4d;
	font-size: 18px;
}

.td_7_realtitle {
	width: 230px;
	float: left;
	text-align: center;
	height: 50px;
	padding-top: 10px;
	border-top: 2px solid #2c3c57;
	border-bottom: 2px solid #2c3c57;
	background: #fff;
	color: #4d4d4d;
	font-size: 18px;
}
</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<!-- font-family:'Nanum Gothic', sans-serif -->

<style>
input[type=button] {
	font-weight: bold;
}

input[type=submit] {
	font-weight: bold;
}

* {
	font-family: 'Nanum Gothic', sans-serif;
	font-weight: bold;
}
</style>
<style>
.titlespan {
	font-weight: bold;
	font-size: 35px;
	text-align:center;
}
#thispagebody{
    padding-left: 93px;
    padding-right: 93px;
    width: 100%;
    height: 100%;
    text-align: center;
}

.MYTEAMLIST_UL{
line-height:33px;
}
.MYTEAMLIST_UL li{
FONT-SIZE:23PX;
}

.MYTEAMLIST_UL a{
}
</style>
<!-- 통합버튼CSS 추가 -->
<link rel="stylesheet" href="css/Button-futsalpark.css">
</head>
<body>


	<div class="sec_ban2 margin2" style="margin-top: 90px;"></div>
	<div name="teamandlegue_button" id="thispagebody">
							<%
								if (myteamlist.size() == 0) {
							%>
							<ul CLASS="MYTEAMLIST_UL">
								<li class="titlespan">등록된 팀이 존재하지 않습니다</li>
								<li><a target="_parent" href="teamcomu.do?command=teamlist">팀가입하러 가기</a></li>
							</ul>
							<%
								} else {
							%>
		<%for(int i=0; i<myteamlist.size(); i++){ %>
		<ul CLASS="MYTEAMLIST_UL">
			<li><a target="_parent" href="team_info.do?command=teaminfo&teamcode=<%=myteamlist.get(i).getT_code()%>" style="color:black;"><span class="titlespan"><%=myteamlist.get(i).getT_name()%></span></a></li>
			<li style="height:200px;margin-top:20px;"><img src="img/<%=myteamlist.get(i).getT_logo()%>" style="height:width:180px;height:180px;"></li>
			<li>팀관리자 : <span><%=myteamlist.get(i).getId()%></span></li>
			<li>랭킹 : <span><%=myteamlist.get(i).getT_ranking()%>위</span></li>
			<li>유니폼(Home) : <span><%=myteamlist.get(i).getT_uniform_home()%></span></li>
			<li>유니폼(Away) : <span><%=myteamlist.get(i).getT_uniform_away()%></span></li>
			<li>팀 생성일 : <span><%=myteamlist.get(i).getT_birth() %></span></li>
			<li><a target="_parent"  href="galList.bo?teamcode=575242&teamname=<%=myteamlist.get(i).getT_name()%>">팀갤러리</a>/<a target="_parent" href="teamboardlist.do?command=teamboardlist&teamcode=575242&teamname=<%=myteamlist.get(i).getT_name()%>">팀게시판</a></li>
			<li style="height: 50px;"></li>
		</ul>
		<%} } %>
	</div>

	</div>

</body>

</html>