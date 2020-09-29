<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//2020_01_02 수정부분
	String uss = (String) session.getAttribute("admin_id");
String name = (String) session.getAttribute("admin_name");

	String log = "로그인";
	if (uss == null)
		uss = "GUEST";
	else
		log = "로그아웃";
	//수정부분 끝
	String headerurl = (String) request.getAttribute("javax.servlet.include.request_uri");
	session.setAttribute("headerurl", headerurl);
	
	String logid = (String) session.getAttribute("admin_id");
	
%>


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
					if($(e.target).parent("a.mypage").length!=1) {
						$(".mypage").removeClass("menu-open");
						$("fieldset#mypage_menu").hide();
					}
				});			
				
			});
	</script>

<!--마이페이지 접근 위한 css 파일 추가 2020.01.15-->
<link href="css/frontlogin.css" media="screen, projection" rel="stylesheet" type="text/css">  

<script type="text/javascript">

function searchselect(){
	location.href="index.do?command=index";
	}



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
font-weight:bold;
}
</style>
<body>

	<header id="header" style="
    height: 176px;">
    

	
		<div id="navtop">
			
			<div id="navtop_menu">
				<ul class="menu">
					<li class="borderRightLeft"><a href="admin_BranchList_view.adm?command=admin_BranchList">지점현황</a>
						</li>
					<li class="borderRightLeft"><a href="admin_MemberList_view.adm?command=admin_MemberList_view">회원정보 리스트</a>
						</li>
					<li class="borderRightLeft"><a href="admin_notice.adm?command=notice">공지사항</a>
						</li>
					<li class="borderRightLeft"><a href="admin_Qna.adm?command=AdminQnaList">Q&A관리</a>
						</li>
					<li class="borderRightLeft"><a href="admin_rank.adm?command=">리그랭킹</a>
						</li>
				</ul>
			</div>
				
			<div id="navtop_login">
				<!--회원상태 창-->
				<div id="container" style="float: left;">
					<div id="topnav" class="topnav">
						<a href="sinlog_1.jsp"> <span><%=log%></span>
						</a>
					</div>
				</div>
				<a href="login" class="signin" style="float: left; line-height: 25px;pointer-events: none;">
				<u style="font-size: 17px; font-weight: 300;    text-decoration: none;"><%=name%>님</u>
				</a>
				<a href="javascript:searchselect();"><img src="img/admin_home_icon.png" style="margin-top: -5px;margin-right: 70px;width: 40px;height: 37px;"> </a>
				<!-- <fieldset id="signin_menu">
					<form name="login" method="post" id="signin">

						<p class="forgot">
							<a href="Mypage.jsp" id="signin">My Page</a>
						</p>
						<p class="forgot">
							<a id="booking" href="">예약조회 </a>
						</p>
						<p class="forgot">
							<a id="board" href="">환불계좌등록 </a>
						</p>
					</form>
				</fieldset> -->

				<!-- <a href="alampage" class="mypage" style="float: left; line-height: 25px;"><img src="img/alam.png" style="width: 30px; height: 30px; margin-left: 10px;" /></a>
				<fieldset id="mypage_menu">
					<form name="alampage" method="post" id="mypage">

						<p class="forgot">
							<a href="logincom.jsp" id="mypage">내가 쓴 게시물</a>
						</p>
						<p class="forgot">
							<a id="bookingclub" href="">즐겨찾는구장 </a>
						</p>
						<p class="forgot">
							<a id="board" href="">환불계좌등록 </a>
						</p>
					</form>
				</fieldset>
 -->



			</div>
			
		</div>
		
		</div>

		
	</header>
</body>

