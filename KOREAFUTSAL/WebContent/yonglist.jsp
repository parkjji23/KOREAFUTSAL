<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.YonglistDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.YonglistDto"%>
<%@ page import="java.util.Date"%>
<%
	String url = request.getServletPath();
	session.setAttribute("url", url);
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
	//2020.01.14 로그인 id 수정
	String yid = (String) session.getAttribute("id");
	ArrayList<YonglistDto> yonglist = (ArrayList<YonglistDto>) request.getAttribute("yonglist");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
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
<title>yonglist</title>

<link rel="stylesheet" href="css/boardpop.css">


<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<!-- 광호Q&A -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--용병리스트 게시판 css파일 수정 2020.01.08-->
<link rel="stylesheet" href="yonglist_1_body.css">
<!----------------------------바디 스타일------------------------------------>

<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">

<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">

<!--배너2 자동슬라이드-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>


<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">
<!-- 20200116 용병 버튼 크기 조절 by 문경이형 -->
<link rel="stylesheet" href="css/signbutton.css">
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
<!--2020.01.09Overray css추가 -->
<link rel="stylesheet" href="css/qnaOverray.css">
<!----------------------------오버레이 화면 띄우는 스크립트------------------------------------>
<script>						
	function selectOne(index,yid) {
		$.ajax({
		type:"get",
		
		url:"./yongSelectOne.jsp",       
		data:{
	
			index:index,
			yid:yid
		},	
		success:whenSuccess2,
		error:whenError2
		});
	}
		function whenSuccess2(resdata){
			console.log(resdata);
			$("#innerpop").html(resdata);
		}
		function whenError2(){
			alert("리스트에러");
		}
</script>
<!--2020.03.24 게시판 css추가 -->
<link rel="stylesheet" href="css/boardstyle.css">
<style>
.pagination li a {
	position: unset;
}

.signbutton6:hover {
	color: #e0e0e0;
}

.signbutton6 {
	background-color: #555555;
	font-size: 19px;
	color: #fff;
}
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
.league_cont .teams_table .search {
    padding: 14px 0 14px 75px;
    background: #2c3c57 url(img/icon_league_search.png) no-repeat 0 center;
    font-size: 0;
    line-height: 47px;
}
.league_cont .teams_table .search_wrap button span {
    display: inline-block;
    padding-right: 30px;
    background: url(img/icon_league_search_s.png) no-repeat right center;
    background-size: auto 40px;
    color: #fff;
    font-size: 18px;
    font-weight: 700;
}
.league_cont .select:after {
    content: "";
    display: block;
    position: absolute;
    right: 12px;
    top: 50%;
    margin-top: -4px;
    width: 13px;
    height: 8px;
    background: url(img/select_arrow.png) no-repeat center center;
    background-size: 11px auto;
}
</style>
<!-- 한글글씨체적용 /아이디찾기 제목-->
<link rel="stylesheet" href="css/galboardstyle.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">

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
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.265446899888!2d127.02924799651784!3d37.492391917303266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5bed583f92d%3A0xc93c837d2875ade6!2z7ZKL7IK07J6l!5e0!3m2!1sko!2skr!4v1575961834128!5m2!1sko!2skr" width="100%" height="100%" frameborder="0" style="border: 0;" allowfullscreen=""></iframe>
			</div>
		</div>
	</div>
	<section id="main" style="height: 1200px;">
		<section id="mainright">
			<div id="matList">
				
				<h3 class="h_tit" style="font-weight:normal;">용 병 등 록 </h3>
				<input class="signbutton signbutton6" type="button" value="용병등록" style="float: right; margin-right: 33px;" onClick="location.href='matyong.do?command=yongsign'">
				
				<div class="cbox">
				<!-- -----------------리스트------------------------ -->
					<div class="league_cont team">
						<div class="teams_table" style="clear: both; width: 950px;">
							<div class="search">
								<form name="frm_search" method="post"
									style="position: relative;"
									action="matyong.do?command=yonglist">
									<span class="select"> <label for="select01"
										style="width: 100%;">전체</label> <select class="select_box"
										name="searchtype" id="select01" style="width: 100%;margin-top: 8px;">
											<option value="all">전체</option>
											<option value="branch">지점</option>
											<option value="name">작성자</option>
											<option value="contents">내용</option>
									</select>
									</span>
									<script>
										$("#select01").change(function(){
											var select_name = $(this).children("option:selected").text();
									        $(this).siblings("label").text(select_name);
										});
									</script>
									<div class="search_wrap">
										<input type="text" name="search" value=""
											placeholder="검색어를 입력하세요" style="width: 350px;">
										<button type="button" class="search_button"
											onclick="this.form.submit();">
											<span>검색</span>
										</button>
									</div>
									<input type="hidden" name="id" id="id" value="<%=uss%>" />
								</form>
							</div>
							<div class="table_wrap">
								<table>
									<caption>팀 테이블</caption>
									<colgroup>
										<col style="width: 289px" class="tb">
										<col style="">
										<col style="width: 161px" class="w07">
										<col style="width: 100px" class="tb">
										<col style="width: 100px" class="w07">
									</colgroup>
									<thead>
										<tr>
											<th scope="col" class="tb">지점</th>
											<th scope="col">매치일자</th>
											<th scope="col">매치시간대</th>
											<th scope="col" class="tb">작성자</th>
											<th scope="col">신청</th>
										</tr>
									</thead>
									<tbody>
										<%
											if (!yonglist.isEmpty()) {
												for (int i = 0; i < yonglist.size(); i++) {
										%>
										<tr>
											<td class="tb"><%=yonglist.get(i).getY_b_branch()%></td>
											<td>
												<div class="emb_wrap">
													<a
														onClick="selectOne(<%=yonglist.get(i).getY_b_no()%>,'<%=yonglist.get(i).getId()%>'); "
														class="button" id="listtt" style="color: #337ab7;"> <%=yonglist.get(i).getY_b_schedule()%></a>
												</div>
											</td>
											<td><%=yonglist.get(i).getY_b_time()%></td>
											<td class="tb"><%=yonglist.get(i).getY_b_name()%></td>
											<td><%=yonglist.get(i).getY_b_status()%></td>
										</tr>
										<%
											}
											}
										%>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- ------------------------------------------------------------ -->
					
					<div id="innerpop"></div>
					<!-- Page -->
						<section id="pageList" style="clear:both; text-align: center;">
					<ul class="pagination">
						<%
							if (nowPage <= 1) {
						%>
						<li><a style="color:black;">이전</a></li>&nbsp;
						<%
							} else {
						%>
						
						<li><a href="matyong.do?command=yonglist&page=<%=nowPage - 1%>">이전</a></li>&nbsp;
						<%
							}
						%>

						<%
							for (int a = startPage; a <= endPage; a++) {
									if (a == nowPage) {
						%>
						<li><a style="color:black;"><%=a%></a></li>
						<%
							} else {
						%>
						<li><a href="matyong.do?command=yonglist&page=<%=a%>"><%=a%>
						</a></li>&nbsp;
						<%
							}
						%>
						<%
							}
						%>

						<%
							if (nowPage >= maxPage) {
						%>
						<li><a style="color:black;">다음</a></li>
						<%
							} else {
						%>
						<li><a href="matyong.do?command=yonglist&page=<%=nowPage + 1%>">다음</a></li>
						<%
							}
						%>
						</ul>
					</section>
						<!-- //Page -->

					
				</div>
			</div>

		</section>
	</section>
	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
</body>
</html>
