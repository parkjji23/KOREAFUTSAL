<%@page import="model.PlayerRegistDto"%>
<%@page import="model.LeagueResultDto"%>
<%@page import="model.LeagueDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//2020_01_02 수정부분
	String url = request.getServletPath();
	session.setAttribute("url",url);
	String includeurl = "header.jsp";
	String uss = (String)session.getAttribute("id");
	String log = "로그인";
	if(uss==null)
		uss="GUEST";
	 else{
	 	log="로그아웃";
		includeurl = "sign_login.jsp";
	 }
//수정부분 끝
%>
<%
	
	ArrayList<LeagueDto> leagueAllList = (ArrayList<LeagueDto>) request.getAttribute("LeagueAllList");
ArrayList<LeagueResultDto> LeagueResultList = (ArrayList<LeagueResultDto>) request.getAttribute("LeagueResultList");
ArrayList<PlayerRegistDto> LeagueplayerList = (ArrayList<PlayerRegistDto>) request.getAttribute("LeagueplayerList");
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>League</title>
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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<link rel="stylesheet" href="css/leaguestyle.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">
<!--2020.01.06footer css추가 -->
<link rel="stylesheet" href="css/footer.css">
<!--배너2 자동슬라이드-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>
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
				/* $(document).mouseup(function(e) {
					if($(e.target).parent("a.signin").length==0) {
						 
					
						$(".signin").removeClass("menu-open");
						$("fieldset#signin_menu").hide();
					}
				});	 */		
				
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
					if($(e.target).parent("a.mypage").length!=0) {
						
						$(".mypage").removeClass("menu-open");
						$("fieldset#mypage_menu").hide();
					}
				});			
				
			});
	</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
<script>
	 /*스크롤 내리면 메뉴 위치 이동하는 기능------따로빼면 작동xxxxxx*/
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
	
	</style>
</head>
<body>
	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft">
		<div id="leftbanner">
			<div id="banner1">
				<a href="introduce_page.jsp" >
					<img src="img/20191211.jpg" width="100%" height="100%" />
				</a>
			</div>
			<div id="banner3">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.265446899888!2d127.02924799651784!3d37.492391917303266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5bed583f92d%3A0xc93c837d2875ade6!2z7ZKL7IK07J6l!5e0!3m2!1sko!2skr!4v1575961834128!5m2!1sko!2skr" width="100%" height="100%" frameborder="0" style="border: 0;" allowfullscreen=""> </iframe>
			</div>
		</div>
	</div>
	<section id="main">
		<section id="mainright">
			<div id="matList">
				<div class="sec_ban2">
				
					<h3 class="h_tit" style="font-weight:normal;">리 그 랭 킹 </h3>
					<table class="table table-striped">
						<thead>
							<tr id="tabletitle">
								<th></th>
								<th scope="col" class="thtitle" style="text-align: center"><span>제목</span></th>
								<th scope="col" class="thname"><span>작성자</span></th>
								<th scope="col" class="thdate"><span>작성일</span></th>
								<th scope="col" class="thview"><span>조회</span></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="thgongji">공지</td>
								<td class="thtitle">
									<a href>필 독 !! 그린컴퓨터 풋살팀 공지사항</a>
								</td>
								<td class="thname">김 팡 호</td>
								<td class="thdate">2019. 12. 10</td>
								<td class="thview">30,589</td>
							</tr>
							<tr>
								<td class="thgongji">공지</td>
								<td class="thtitle">
									<a href> 사진 깨짐 현상이 일어나는 이유 !</a>
								</td>
								<td class="thname">김 팡 호</td>
								<td class="thdate">2019. 12. 08</td>
								<td class="thview">89,152</td>
							</tr>
							<tr>
								<td class="thgongji">공지</td>
								<td class="thtitle">
									<a href> 자유롭게 팀의 사진을 올리시면 됩니다 !</a>
								</td>
								<td class="thname">김 팡 호</td>
								<td class="thdate">2019. 12. 05</td>
								<td class="thview">60,895</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="text-center">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						
					</ul>
				</div>
				<div class="galsearch">
					<img src="img/search.jpg" id="leaguesearchimg">
					<form name=selectleaguename action="league_main.do?command=league_main" method="post">
					<select class="form-control" id="leaguemonth" name="lcode">
					<%for(int i=0; i<leagueAllList.size(); i++){ %>
						<option value=<%=leagueAllList.get(i).getLeague_code() %>><%=leagueAllList.get(i).getLeague_name() %></option>
					<%} %>
					</select>
					<button type="button" class="btn_search" onclick="this.form.submit();">리그선택</button>
					</form>
				</div>
				<div class="teamrank">
					<h4 class="h_bar">
						<strong>TEAM</strong> RANKING
					</h4>
					<div class="rank">
						<table>
							<caption>TEAM RANKING 테이블</caption>
							<colgroup>
								<col style="width: 13%;">
								<col style="">
								<col style="width: 11%">
								<col style="width: 11%">
								<col style="width: 11%">
								<col style="width: 11%">
							</colgroup>
							<thead>
								<tr id="rankhead">
									<th scope="col">순위</th>
									<th scope="col">팀명</th>
									<th scope="col">승점</th>
									<th scope="col">승</th>
									<th scope="col">무</th>
									<th scope="col">패</th>
								</tr>
							</thead>
							<tbody>
							<%if(!LeagueResultList.isEmpty()){ %>
							<%for(int i=0; i<LeagueResultList.size(); i++){ %>
								<tr>
									<td><%=i+1 %></td>
									<td>
										<div class="emb_wrap">
											<a href="team_info.do?command=teaminfo&teamcode=<%=LeagueResultList.get(i).getT_code()%>">
												<span class="emb"><img src="/files/team/emblem_1635.jpg" alt=""></span> <span class="team">
												<%=LeagueResultList.get(i).getT_name() %></span></a></div>
									</td>
									<td><%=LeagueResultList.get(i).getLeague_point() %></td>
									<td><%=LeagueResultList.get(i).getLeague_win() %></td>
									<td><%=LeagueResultList.get(i).getLeague_draw() %></td>
									<td><%=LeagueResultList.get(i).getLeague_lose() %></td>
								</tr>
							<%} }else{%>
								<tr>
									<td></td>
									<td>
										<div class="emb_wrap">
											<span class="emb"><img src="/files/team/emblem_1635.jpg" alt=""></span> <span class="team">팀이 존재하지 않습니다.</span>
											
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							<%} %>
								
							</tbody>
						</table>
					</div>
				</div>
				<div class="playerrank">
					<h4 class="h_bar">
						<strong>PLAYER</strong> RANKING
					</h4>
					<div class="player">
						<table>
							<caption>TEAM RANKING 테이블</caption>
							<tbody>
							
							<%if(!LeagueplayerList.isEmpty()){ %>
							<%for(int i=0; i<LeagueplayerList.size(); i++) {%>
								<tr id="rankhead">
									<td>
										<img src="img/<%=LeagueplayerList.get(i).getPic() %>" width=150px height=140px style="float: left">
									</td>
									<td>득점 <%=i+1 %>위 <%=LeagueplayerList.get(i).getName() %></td>
								</tr>
							<%}}else{ %>
							
								<tr id="rankhead">
									<td>
										<img src="img/mypage_icon.png" width=150px height=140px style="float: left">
									</td>
									<td>선수가 존재하지 않습니다.</td>
								</tr>
							<%} %>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
		</section>
	</section>

	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
	<jsp:include page="quickbar.jsp" />
</body>
</html>
