<%@page import="vo.QnaDto"%>
<%@page import="dao.QnaDao"%>
<%@page import="vo.QnaDto" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BranchDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%
    	
    	
    	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) request.getAttribute("BranchList");
    	
    	
    	
	

	//2020_01_02 수정부분
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

%>

<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">
<!--2020.01.06footer css추가 -->
<link rel="stylesheet" href="css/footer.css">
<!--배너2 자동슬라이드-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>




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
function searchselect(){
	var search = document.getElementById("search");
	var val = search.options[search.selectedIndex].value;  //0은 제목 1은 내용
	var word = document.getElementById("sel").value;
	alert(val+word);
	document.location.href="qna.do?command=qnasearch&searchword="+word+"&searchsetting="+val;
	
	}

	

	


function searchselect1(){
	var search = document.getElementById("search");
	var val = search.options[search.selectedIndex].value;  //0은 제목 1은 내용
	$.ajax({
		type:"post",
	url:"./qna.do?command=qnasearch",       
	data:{
	
		searchword:$('#sel').val(),
		searchsetting: val
		
	},	
	success:whenSuccess,
	error:whenError
	});
	}
	var confirmid = "";
	function whenSuccess(resdata){
	alert(resdata);
	//document.location.href="qna.jsp";
	}
	function whenError(){
	alert("Error");
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
</style>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft" style="    height: 800px;">

	</div>
	<section id="main">
		<section id="mainright" style="height: 75%;">
			<div id="matList">
				<div class="sec_ban2">
					<ul class="nav_ban">
						<li><h3
								style="margin-bottom: 30px; margin-top: 5px; font-size: 50px; font-family: 'NanumBarunGothicL'; line-height: 60px; text-align: center;">지점 현황</h3></li>
					</ul>
				</div>
				
							
								<div class="cbox2" style="height: 65px;" >
										<table class="table table-striped">
						<thead>
							<tr id="tabletitle">
								<th scope="col" class="thno"><span> No </span></th>
								<th scope="col" class="thtitle" style="text-align: center"><span>
										지점명 </span></th>
								<th scope="col" class="thname" style="padding-right: 45px;"><span>작성자 </span></th>
								<th scope="col" class="thname"style=" padding-right: 45px;    padding-left: 3px;"><span>상태 </span></th>
							
							</tr>
						</thead></table></div>

				<div class="cbox2" style="height: 600px;overflow-y:scroll;    padding-top: 0px;" >
					<table class="table table-striped">
				
						
						<tbody >
						

								<%
									for (int i = 0; i < BranchList.size(); i++) {
								%>
								<a>
									<tr>
										<td class="thgongji" style="text-align: left;"><%=BranchList.get(i).getBranch_no()%></td>
										<td class="thtitle"><a class="button" id="listtt" href="admin_BranchList_view.adm?command=admin_BranchList_view&branch_no=<%=BranchList.get(i).getBranch_no()%>; ">
										<%=BranchList.get(i).getBranch_name()%></a> </td>
										<td class="thname" name="thname" id="thname"><%=BranchList.get(i).getName()%></td>
										<td class="thname" name="thname" id="thname"><%=BranchList.get(i).getBranch_state()%></td>
								
									</tr>
								</a>
								<%
									}
							
								%>



						</tbody>
						
					</table>
		
				</div>
		</section>
	</section>



	
</body>
</html>