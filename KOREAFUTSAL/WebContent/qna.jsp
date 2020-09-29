<%@page import="vo.PageInfo"%>
<%@page import="vo.QnaDto"%>
<%@page import="dao.QnaDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String logid = (String) session.getAttribute("id");
	%>
	
<% 
	ArrayList<QnaDto> qnaList = (ArrayList<QnaDto>) request.getAttribute("qnaList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>
<!-- 자동로그인 2020.03.25by pang -->
<%
	String uss = (String) session.getAttribute("id");
	Cookie[] c = request.getCookies();
	if (c != null) {
		for (Cookie cf : c) {
			if (cf.getName().equals("id")) {
				String ids = cf.getValue();
				session.setAttribute("id", ids);
				uss = (String) session.getAttribute("id");
			}
		}
	}
	String url = request.getServletPath();
	session.setAttribute("url", url);
	//2020_01_02 수정부분
	String includeurl = "header.jsp";

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
%>

<!-- 자동로그인 끝 2020.03.25by pang -->
<jsp:useBean id="dao" class="dao.QnaDao" />
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<title>qna</title>
<link rel="stylesheet" href="css/boardpop.css">
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
<!--Q&A에 펠요한 css-->
<link rel="stylesheet" href="css/Q&Astyle.css" media="screen">
<!-- Q&A에 필요한 script -->
<script type="text/javascript" src="Q&Ascript.js"></script>
<!-- 광호Q&A -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<link rel="stylesheet" href="css/Q&Astyle2.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">
<!--2020.01.06footer css추가 -->
<link rel="stylesheet" href="css/footer.css">
<!--배너2 자동슬라이드-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>
<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">
<!--2020.01.09Overray css추가 -->
<link rel="stylesheet" href="css/qnaOverray.css">

<!----------------------------회원가입스크립트랑 스타일(따로 빼면 에러)-------------------------->
<script type='text/javascript'>
	$(function() {
		  $('#forgot_username_link').tipsy({gravity: 'w'});   
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
			if($(e.target).parent("a.signin").length==0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
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
					if($(e.target).parent("a.mypage").length!=1) {
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
<!----------------------------오버레이 화면 띄우는 스크립트------------------------------------>
<script>						
	function selectOne(index) {
		$.ajax({
		type:"get",
		
		url:"./qnaSelectOne.jsp",       
		data:{
	
			index:index
		},	
		success:whenSuccess2,
		error:whenError2
		});
	}
		function whenSuccess2(resdata){
			$("#innerpop").html(resdata);
		}
		function whenError2(){
			alert("리스트에러");
		}
</script>
<!----------------------------- 비밀글설정-------------------------------- -->
<script type="text/javascript">
	$(document).ready(function() {

		$("input:radio[name=q_b_secret]").click(function() {

			if ($("input[name=q_b_secret]:checked").val() == "sc") {

				$("input:password[name=q_b_secretcode]").attr("disabled", false);

			} else if ($("input[name=q_b_secret]:checked").val() == "pb") {
				$("input:password[name=q_b_secretcode]").attr("disabled", true);

			}
		});
	});
</script>
<script>
function qnasubmit(){

	var titlelen = qnainsert.q_b_title.value.length
	var namelen = qnainsert.q_b_name.value.length
	var pwlen = qnainsert.q_b_secretcode.value.length
	var contentlen = qnainsert.q_b_contents.value.length
	if (titlelen <= 0) {
		alert("제목을 입력해주세요.");
		qnainsert.q_b_title.focus();
	} else if (namelen <= 0) {
		alert("작성자를 입력해주세요.");
		qnainsert.q_b_name.focus();
	} else if (pwlen <= 3) {
		alert("4자리 이상 비밀번호를 입력해주세요.");
		qnainsert.q_b_secretcode.focus();
	} else if (contentlen <= 0) {
		alert("문의 내용을 입력해주세요.");
		qnainsert.q_b_contents.focus();
	}
	 else {
			document.qnainsert.submit();
		}
	}

</script>
<style>
#qnaTopTable td div {
	height: 50px;
	margin: 0px;
}

.nav_ban {
	margin-top: 0px;
	padding: 0px;
}

.pagination li a {
	position: unset;
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
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.265446899888!2d127.02924799651784!3d37.492391917303266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5bed583f92d%3A0xc93c837d2875ade6!2z7ZKL7IK07J6l!5e0!3m2!1sko!2skr!4v1575961834128!5m2!1sko!2skr"
					width="100%" height="100%" frameborder="0" style="border: 0;"
					allowfullscreen=""> </iframe>
			</div>
		</div>
	</div>
	<section id="main" style="height:1500px;">
		<section id="mainright">
			<div id="matList">
				<div class="sec_ban2">
					<h3 class="h_tit" style="font-weight: normal;">고 객 센 터</h3>
				</div>
				<div class="cbox1">
					<form name = "qnainsert" id="qnainsert" action="qnaInsert.jsp" method="post">
						<table class="table table-striped" id="qnaTopTable">
							<tbody>
								<tr>
									<td style="width: 200px; padding-top: 23px; font-size: 18px;">작성자</td>
									<td>
										<div class="form-group has-success">
											<input type="text" class="form-control" id="q_b_name"
												name="q_b_name" maxlength="10"
												style="width: 250px; margin-top: 7px;">
										</div>
									</td>
								</tr>
								<tr>
									<td style="width: 200px; padding-top: 23px; font-size: 18px;">이메일</td>
									<td>
										<div class="form-group has-success">
										<label class="control-label"style="color: #8a6d3b;padding-right: 450px;">답변을 받으실 이메일주소를 정확하게 작성해주세요</label>
											<input type="text" class="form-control" id="q_b_email"
												name="q_b_email" style="width: 250px; margin-top: 7px;">
										</div>
									</td>
								</tr>
								<tr>

								</tr>
								<tr>
									<td style="width: 200px; padding-top: 23px; font-size: 18px;">비밀번호
										설정</td>
									<td>
										<div class="form-group has-warning"
											style="height: 45px; text-align: left;">
											<label class="control-label" for="inputWarning1"
												style="color: #8a6d3b;"> 글 수정,삭제시 사용됩니다. </label>
											<div class="checkbox" style="height: 25px;">
												<label for="qSecret"> <input type="radio"
													id="q_b_secret" name="q_b_secret" value="sc" checked>비밀번호
													설정
												</label>
											</div>
											<input type="password" class="form-control"
												id="q_b_secretcode" name="q_b_secretcode" maxlength="10"
												style="width: 250px; margin-top: 7px;">
										</div>
									</td>
								</tr>
								<tr>
									<td style="width: 200px; padding-top: 23px; font-size: 18px;">제목</td>
									<td>
										<div class="form-group has-success">
											<input type="text" class="form-control" id="q_b_title"
												name="q_b_title" style="width: 670px; margin-top: 7px;">
										</div>
									</td>
								</tr>
								<tr>
									<td style="width: 200px; padding-top: 23px; font-size: 18px;">내용</td>
									<td><textarea id="q_b_contents" name="q_b_contents"
											class="form-control" rows="7"
											style="resize: none; width: 670px;"></textarea></td>
								</tr>
								<input type="hidden" id="q_b_status" name="q_b_status" value="질문" />
							</tbody>
							</form>
						</table>
						<a href="qna.jsp" class="btn btn-default"
							style="float: right; margin-left: 5px; font-weight: bold;">목록
						</a> <input type="button" value="글쓰기" onClick="qnasubmit()";
							class="btn btn-default pull-right" style="margin-right: 20px;" />
						<br> <br> <br>
				</div>

				<div class="cbox2" style="    margin-top: 50px;">
					<table class="table table-striped">
						<thead>
							<tr id="tabletitle">
								<th scope="col" class="thno" style="font-size: 18px;"><span>
										No </span></th>
								<th scope="col" class="thtitle"
									style="text-align: center; font-size: 18px;"><span>
										제목 </span></th>
								<th scope="col" class="thname" style="font-size: 18px;"><span>
										작성자 </span></th>
								<th scope="col" class="thdate" style="font-size: 18px;"><span>
										작성일 </span></th>
								<th scope="col" class="thview" style="font-size: 18px;"><span>
										조회 </span></th>
							</tr>
						</thead>
						<tbody>
							<%
								if (!qnaList.isEmpty()) {
									for (int i = 0; i < qnaList.size(); i++) {
							%>
							<a>
								<tr>
									<td class="thgongji"
										style="text-align: left; padding-top: 12px; padding-bottom: 12px;"><%=qnaList.get(i).getQ_b_no()%></td>
									<td class="thtitle"
										style="font-size: 18px; padding-top: 12px; padding-bottom: 12px;">
										<a onClick="selectOne(<%=qnaList.get(i).getQ_b_no()%>); "
										class="button" id="listtt"><%=qnaList.get(i).getQ_b_title()%></a>
									</td>
									<td class="thname" name="thname" id="thname"
										style="font-size: 18px; padding-top: 12px; padding-bottom: 12px;"><%=qnaList.get(i).getQ_b_name()%></td>
									<td class="thdate"
										style="font-size: 17px; padding-top: 12px; padding-bottom: 12px;"><%=qnaList.get(i).getQ_b_date()%></td>
									<td class="thview"
										style="font-size: 17px; padding-top: 12px; padding-bottom: 12px;"><%=qnaList.get(i).getQ_b_readcount()%></td>

								</tr>
							</a>
							<%
								}
								}
							%>

							<div id="innerHtml"></div>

							<div id="innerpop"></div>



						</tbody>
					</table>
					<!-- Page -->
					<section id="pageList" style="clear: both; text-align: center;">
						<ul class="pagination">
							<%
								if (nowPage <= 1) {
							%>
							<li><a style="color: black;">이전</a></li>&nbsp;
							<%
								} else {
							%>
							<li><a href="qna.do?command=qna&page=<%=nowPage - 1%>">이전</a></li>&nbsp;
							<%
								}
							%>
							<%
								for (int a = startPage; a <= endPage; a++) {
									if (a == nowPage) {
							%>
							<li><a style="color: black;"><%=a%></a></li>
							<%
								} else {
							%>
							<li><a href="qna.do?command=qna&page=<%=a%>"><%=a%> </a></li>&nbsp;
							<%
								}
							%>
							<%
								}
							%>
							<%
								if (nowPage >= maxPage) {
							%>
							<li><a style="color: black;">다음</a></li>
							<%
								} else {
							%>
							<li><a href="qna.do?command=qna&page=<%=nowPage + 1%>">다음</a></li>
							<%
								}
							%>
						</ul>
					</section>
					<!-- //Page -->
					<form name="mat_search" method="post" action="qna.do?command=qna"
						style="margin-left: 200px;">
						<select class="form-control" name="searchtype" id="searchtype"
							style="width: 200px; float: left; margin-left: 10px;">
							<option value="all">전체</option>
							<option value="name">작성자</option>
							<option value="contents">내용</option>
						</select> <input type="text" class="form-control" id="sel"
							placeholder="검색어를 입력하세요" class="form-control" name="search"
							style="width: 300px; float: left; margin-left: 10px;"> <input
							class="btn btn-default" type="button" value="검 색"
							onclick="this.form.submit();"
							style="float: left; margin-left: 10px;">
					</form>
				</div>
		</section>
	</section>


	<footer id="footer">
		<jsp:include page="Footer.jsp" />
	</footer>
	<jsp:include page="quickbar.jsp" />
</body>
</html>