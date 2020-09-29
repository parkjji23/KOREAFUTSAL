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
	ArrayList<ReservationDto> reservationlist = (ArrayList<ReservationDto>) request.getAttribute("reservationlist");
	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) request.getAttribute("BranchList");
	ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) request.getAttribute("GroundList"); 
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
<html lang="en" style="overflow-y: hidden; overflow-x: hidden;"> <!-- iframe들어가는 박스에 스크롤 안생기게 -->
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
#reservationtable{
border: 1px solid #444444;
margin-left: -260px;
font-size:17px;
text-align:center;
}
.td_divstyle{
width:149px;
float:left;
text-align:center;
border: 1px solid #444444;
height: 45px;
}
.restb{
text-align:center;
border: 1px solid #444444;
height: 45px;
width:150px;
float:left;
}
/* 표큰테두리스타일 */
#tablediv{
width: 1230px;
height:1350px;
margin-left: -319px;
}
.td_1_title{
width:130px;
float:left;
text-align:center;
height: 50px;
}
.td_1{
    font-size: 16px;
    font-weight: 700;
    color: white;
width:130px;
float:left;
text-align:center;
height: 50px;
padding-top: 14px;
border-bottom: 1px solid #d5d8dd;
}
.td_2_3_title{
width:150px;
float:left;
text-align:center;
height: 50px;
}
.td_2_3{
font-size: 16px;
    font-weight: 700;
    color: #777;
width:150px;
float:left;
text-align:center;
border-bottom: 1px solid #d5d8dd;
height: 50px;
padding-top: 14px;
}
.td_4_6_title{
width:149px;
float:left;
text-align:center;
height: 50px;
}
.td_4_6{
font-size: 16px;
    font-weight: 700;
    color: #777;
text-align:center;
border-bottom: 1px solid #d5d8dd;
height: 50px;
width:150px;
float:left;
padding-top: 14px;
}
.td_5_title{
width:200px;
float:left;
text-align:center;
height: 50px;
}
.td_5{
font-size: 16px;
    font-weight: 700;
    color: #777;
width:200px;
float:left;
text-align:center;
border-bottom: 1px solid #d5d8dd;
height: 50px;
padding-top: 14px;
}
.td_7_title{
width:230px;
float:left;
text-align:center;
height: 50px;
}
.td_7{
font-size: 16px;
    font-weight: 700;
    color: #777;
width:230px;
float:left;
text-align:center;
border-bottom: 1px solid #d5d8dd;
height: 50px;
padding-top: 14px;
}
.td_7_button{
width:230px;
float:left;
text-align:center;
border-bottom: 1px solid #d5d8dd;
height: 50px;
padding-top:4px;
}
.paybutton{
background-color: #4c89cd;
color:white;
width: 107px;
height:40px;
border: 1px solid #4440;
font-size: 16px;
letter-spacing: 7px;
height: 48px;
}
.cancelbutton{
background-color: #fff;
color:#777;
width:107px;
height:40px;
border: 1px solid #4440;
font-size: 16px;
}
.td_1_realtitle{
width:130px;
float:left;
text-align:center;
height: 50px;
padding-top: 10px;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
        font-size: 18px;
}
.td_2_3_realtitle{
width:150px;
float:left;
text-align:center;
height: 50px;
padding-top: 10px;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
        font-size: 18px;
}
.td_4_6_realtitle{
width:149px;
float:left;
text-align:center;
height: 50px;
padding-top: 10px;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
        font-size: 18px;
}
.td_5_realtitle{
width:200px;
float:left;
text-align:center;
height: 50px;
padding-top: 10px;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
        font-size: 18px;
}
.td_7_realtitle{
width:230px;
float:left;
text-align:center;
height: 50px;
padding-top: 10px;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
        font-size: 18px;
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
button[type=button]{
font-weight:bold;
}
*{
font-family:'Nanum Gothic', sans-serif;
font-weight:bold;
}
</style>
</head>
<body>
<section id="main">
		<section id="mainright" >
			<div id="matList">
				<div class="sec_ban2 margin2" style="margin-top: 90px;">
							<input type="hidden" name="id" id="id" value="<%=uss%>" />
				</div>
				<!--!!!!!!!!!!!!!id 구해서 숨겨놓기!!!!!!!!!!!!!!! -->
				<input type="hidden" id="idvalue" name="idvalue" value="<%=reservationlist.get(0).getId() %>">
				<div id="tablediv" style="overflow-y:scroll; ">
				<%
				if(reservationlist != null){
				%>					
				<!-- res_status가 30인 데이터는 띄우지않기 -->
				<div class="league_cont team" >
						<div class="teams_table" style="clear: both; width: 1120px;">
							<div class="table_wrap">
							<div style="font-weight:none;color:red;font-size:15px;">- 예약시간 기준으로 24시간 내에 결제가 완료되지 않으면 대관이 취소됩니다.</div>
				<table>
									<colgroup>
										<col style="width:158px">
										<col style="width:165px;">
										<col style="width:123px">
										<col style="width:171px;">
										<col style="width:326px;">
										<col style="width:162px;" >
										<col style="width:170px;" >
										<col style="width:131px;" >
									</colgroup>
				<thead>
										<tr>
											<th scope="col">주문일자</th>
											<th scope="col">지점이름</th>
											<th scope="col">구장이름</th>
											<th scope="col">예약날짜</th>
											<th scope="col">예약시간</th>
											<th scope="col">결제금액</th>
											<th scope="col">결제/취소</th>
											<th scope="col">대관상태</th>
										</tr>
									</thead>
									<tbody>
										<%
											if (!reservationlist.isEmpty()) {
												for(int i=0; i<reservationlist.size(); i++){
													int statusnumber = reservationlist.get(i).getRes_status();
													if(statusnumber != 30){
											
										%>
										<tr>
											<td style="line-height: 20px;"><%=reservationlist.get(i).getRES_MOMENT() %></td>
											<td><%=BranchList.get(i).getBranch_name()%></td>
											<td><%=GroundList.get(i).getGround_name()%></td>
											
											<td><%=reservationlist.get(i).getRes_date()%></td>
											<td><%=reservationlist.get(i).getRes_time() %></td>
											<td><%=reservationlist.get(i).getPayment_charge() %> (원)</td>
											<!-- resstatus숨겨놓기 -->
											<input type="hidden" id="res_status_num" name="res_status" value="<%=reservationlist.get(i).getRes_status() %>">
									<td>
									<% //지난날짜비교하기
									SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
									
									Date currentTime = new Date(); //Wed Mar 25 16:29:30 KST 2020 ->now()
									String current = dateFormat.format(currentTime);//2020-03-25 [형식통일]
									
									String resMoment = reservationlist.get(i).getRES_MOMENT();//2020-03-24 01:02:03 (String)
									Date resMoment2 = dateFormat.parse(resMoment);//2020-03-24 01:02:03 (Date)
									String moment = dateFormat.format(resMoment2);//2020-03-24 [형식통일]
									
									int result = current.compareTo(moment);//비교후 1뽑아냄
									%>
										<!-- 지난날짜일때 -->
										<% if(result==1){%>
									-
										
									<%   /* 지난날짜가아닐때 */
									}else{%>	
									<% if(statusnumber == 10){%>
											<button type="button" style="letter-spacing:2px;padding-left: 4px;
    										height: 45px;" value="<%=reservationlist.get(i).getRes_no() %>"
											class="paybutton" name="paybutton">결제하기</button>
									<% }%>
											<button type="button" style="color:white;letter-spacing: 2px;background-color:#ccc;padding-left:1px;
   											 height: 45px;" value="<%=reservationlist.get(i).getRes_no() %>"
											class="cancelbutton" name="cancelbutton">예약취소</button>
									<%} %>
									</td>
									
									
									
									<td style="line-height: 20px;">
									<%if(reservationlist.get(i).getRes_status() == 10){%>
									예약
									<%}else if(reservationlist.get(i).getRes_status() == 20){ %>
									대관완료
									<%}
									if(result==1){
									%>
									<div style="font-size:13px;color:gray;">[만료대관내역]</div>
									<%} %>
									</td>
										</tr>
										<%
											}
											}
											}
										%>

									</tbody>
				</table>
				</div>
						</div>
					</div>
					<%} %>
						<script>
							$(document).ready(function() {
							 $(".cancelbutton").click(function(e) { 
							var cancel_question = confirm( '예약을 취소하시겠습니까?' );
							console.log( cancel_question );
							var mine2 = $(this).val();
							var idid = $('#idvalue').val();
							console.log(mine2);
							if(cancel_question == true){
							location.href="reservation.do?command=delete_reservation&id="+idid+"&res_no="+mine2;
							alert("예약이 취소되었습니다");
							}else{
								window.onload();
							}
							 }); 
							 
							 $(".paybutton").click(function(e) { 
									var mine2 = $(this).val();
									var idid = $('#idvalue').val();
									location.href="reservation.do?command=mypagestatuschange&id="+idid+"&res_no="+mine2;
									alert("결제가 완료되었습니다");
									 }); 
							});
						</script>
				</div>	
			</div>
		</section>
	</section>

</body>
</html>