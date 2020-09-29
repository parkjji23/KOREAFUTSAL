<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%@page import="model.NoticeboardDto"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<NoticeboardDto> NoticeboardList2 = (ArrayList<NoticeboardDto>) request.getAttribute("NoticeboardList2");%>


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
String admin_name = (String) session.getAttribute("admin_name");

%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>게시물조회</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/datepicker.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/common/form_check.js"></script>

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
<!--큰글씨 폰트 css 파일 추가-->
<link rel="stylesheet" href="css/galboardstyle.css">
<link rel="stylesheet" href="css/signbutton.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">

<link rel="stylesheet" href="css/galstyle.css" media="screen">
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
			if ($(e.target).parent("a.mypage").length != 0) {
				$(".mypage").removeClass("menu-open");
				$("fieldset#mypage_menu").hide();
			}
		});

	});
</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">

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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- ------------------------------------------------------------------------- -->


</script>



<style>
#galview table {
	border: 1px;
	height: 900px;
	align: center;
}

.viewsubject {
	text-align: center;
	font-size: 20px;
	width: 100px;
	font-weight: bold;
}

.viewform {
	font-size: 13px;
	width: 750px;
}

#viewform2 {
	font-size: 13px;
	width: 750px;
	height: 400px;
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
.h_tit {
    position: relative;
    margin-bottom: 45px;
    padding-bottom: 24px;
    font-size: 60px;
   
    line-height: 60px;
    text-align: center;
}
#rep{
	width:100%; height:60px;
	
	padding-top:15px;
	
}
#GB_REP_CONTENTS{
	width:91%; height:35px;
	float:left;
}
#repSubmit{
	float:left;
	position: relative;
    top: -4px;
}
#repContents{
	width:82%;
}
#repId{
	width:10%;
}
#repDate{
	width:15%;
}
</style>
</head>
<body>

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
						<div class="writeboardtitle h_tit">공지사항 상세보기</div>
						

						<div class="container" id="formInnerWrapper">

							<table>
							
		
				<%
											for (int i = 0; i < NoticeboardList2.size(); i++) {
										%>
										
											<tr style="padding: 15px 15px 22px 15px;border-top: 2px solid #2c3c57;">
									
									<td class="viewform" colspan="2" style="font-size:55px;padding-left: 40px;"><%=NoticeboardList2.get(i).getN_title()%></td>
								</tr>
								<tr style="padding: 15px 15px 22px 15px; border-bottom: 1px solid #d5d8dd;padding-left: 40px;">
									<td class="viewsubject"><%=NoticeboardList2.get(i).getN_date() %></td>
									
								</tr>
									<tr>
									<td rowspan="2" class="viewsubject"  style="border-bottom: 2px solid #2c3c57;">내용</td>
								</tr>
								<tr style="border-bottom: 2px solid #2c3c57;">
									
									
									<td class="viewform" style="height: 100px;">
										<%=NoticeboardList2.get(i).getN_contents()%>
									</td>
								</tr>
										

										<%
											}
										%>
							
							
						
							</table>
							
					
							
							
						
								
								
								
								
								
								</table>
							
							
							</div>
						</div>

							<!--@@@@@@@@@@@@@@@@  -->
					
					</center>

				</div>
			
			<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
			<script src="js/materialForm.js"></script>
			</div>

		</section>


	</section>



	
</body>
</html>

</body>
</html>