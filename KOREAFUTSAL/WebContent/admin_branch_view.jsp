<%@page import="vo.GalRepDto"%>
<%@page import="vo.GalBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.BranchDto"%>
<%@page import="model.AdminBranchRepDto"%>

<%
	GalBoardDto article = (GalBoardDto) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
	
	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) request.getAttribute("BranchList");
	String name = (String) session.getAttribute("admin_name");
	
	ArrayList<AdminBranchRepDto> AdminBranchRepList = (ArrayList<AdminBranchRepDto>) request.getAttribute("AdminBranchRepList");
%>

<%
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


<!-- -----------------다음 주소 api ----------------------------------------->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- ------------------------------------------------------------------------- -->
<!-- -------------------------ID 중복확인에 대한 ajax--------------------------------- -->
<script type="text/javascript">
	

	function callAjax5() {

		$.ajax({
			type : "post",
			url : "./adminBranchRepPro.adm?command=adminBranchRepPro",
			data : {

				branch_rep_contents : $('#branch_rep_contents').val();
				branch_no : $('#branch_no').val();
				name : $('#name').val();
			},
			success : whenSuccess5,
			error : whenError5
		});
	}
	var confirmid = "";
	function whenSuccess5(resdata) {

	

		if(resdata!=null){
			alert(resdata);
	
			location.reload();
		}
	}
	function whenError5() {
		alert("Error");
	}

	//	<!--js 파일 분리가 안돼서 어쩔수없이 이곳에 사용한 용병가입 창 js 파일 2020.01.09           + 유효성 검사 2020.01.16 by 종혁형-->
	function yongjoinsubmit() {
		var getName = (/^[가-힣]+$/);
		var date_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
		var regPhone2 = /(\d{3}|\d{4})$/;
		var regPhone3 = /(\d{4}$)/;
		var yBranchlen = yongjoin.yBranch.value.length
		var yGroundlen = yongjoin.yGround.value.length
		var yMemberlen = yongjoin.yMember.value.length
		var yTel1len = yongjoin.yTel1.value.length
		var yTel2len = yongjoin.yTel2.value.length
		var yTel3len = yongjoin.yTel3.value.length
		var yMatchdatelen = yongjoin.yMatchdate.value.length
		var yTimelen = yongjoin.yTime.value.length
		var yApplylen = yongjoin.yApply.value.length
		var yTeamlen = yongjoin.yTeam.value.length

		if (yBranchlen <= 0) {
			alert("지점을 선택하세요.");
			yongjoin.yBranch.focus();

		} else if (yGroundlen <= 0) {
			alert("구장을 선택하세요.");
			yongjoin.yGround.focus();
		} else if (yMemberlen <= 1 || !getName.test(yongjoin.yMember.value)) {
			alert("이름을 정확히 입력하세요.ex)홍길동");
			yongjoin.yMember.focus();
		} else if (yTel1len <= 0 || !regPhone2.test(yongjoin.yTel2.value)
				|| !regPhone3.test(yongjoin.yTel3.value)) {
			alert("전화번호를 입력하세요.ex)010-5555-6666");
			yongjoin.yTel1.focus();
		} else if (!date_pattern.test(yongjoin.yMatchdate.value)) {
			alert("매치일정을 정확히 입력하세요.ex)2020-08-20");
			yongjoin.yMatchdate.focus();
		} else if (yTimelen <= 0) {
			alert("시간을 선택하세요.");
			yongjoin.yTime.focus();
		} else if (yApplylen <= 0) {
			alert("마감여부를 선택하세요.");
			yongjoin.yApply.focus();
		} else if (yTeamlen <= 0) {
			alert("팀 수준을 선택하세요.");
			yongjoin.yTeam.focus();
		} else {
			document.yongjoin.submit();
		}

	}
</script>


<!-- 비밀번호 체크 ajax -->
<script type="text/javascript">
	function callAjax2() {
		if (join.pw.value != join.pwch.value) {
			$("#pwReturn").html("비밀번호가 일치하지 않습니다");
		} else {
			$("#pwReturn").html("");
			
		}
	}
</script>

<!-- 진행사항 변경박스 ajax -->
<script>
	$(document).ready(function() {
		var momo = "";
		$("#smomo").change(function() {

			var momo = document.getElementById("smomo").value;

			alert(momo);
			$("#branch_state").val(momo);
		});
	});
</script>

<style>
#galview table {
	border: 1px;
	height: 900px;
	align: center;
}

.viewsubject {
	padding-left: 10px;
	font-size: 20px;
	width: 150px;
	font-weight: bold;
}
.viewsubject1 {
	padding-left: 10px;
	font-size: 16px;
	width: 150px;
	
}

.viewform {
    padding-left: 10px;
	font-size: 20px;
	width: 450px;
	
}

.viewform1 {
	font-size: 18px;
	width: 450px;
	font-weight: bold;
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
#branch_rep_contents{
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
	text-align: right;
	font-size: 11px;
}
#repDate{
	width:6%;
	font-size: 11px;
}
</style>
</head>
<body>

	<header style="height: 140px">
		<jsp:include page="<%=includeurl%>" />
	</header>
	<div id="mainleft" style="height: 800px;margin-left: 0px;">


		<div id="leftbanner">
		
		</div>


	</div>
	<section id="main">


		<section id="mainright">
			<div id="matList">

				<div class="container" id="formOutterWrapper" style=" margin-top: 0px;">
					<center>
						<div class="writeboardtitle h_tit">지점현황 상세보기</div>
						

						<div class="container" id="formInnerWrapper">
                          
							<table>
							<%
									for(int i=0; i<BranchList.size(); i++){
								%>
								<tr style="padding: 15px 15px 22px 15px;border-top: 2px solid #2c3c57;">
									<td class="viewsubject1">번호:<%=BranchList.get(i).getBranch_no() %></td>
								
											
											
											<td>	<span style="float:right">
											<select  id="smomo" name="smomo" style="margin-right: 56px;">
										<option value="<%=BranchList.get(i).getBranch_state()%>"><%=BranchList.get(i).getBranch_state()%></option>
										<option >진행중</option>
										<option >완료</option>
										<option >중지</option>
										
									</select></span>
									</td>
								</tr>
								
								
								
								
								<tr style="padding: 15px 15px 22px 15px; border-bottom: 1px solid #d5d8dd;padding-left: 40px;">
									<td class="viewform" colspan="1" >지점명: <%=BranchList.get(i).getBranch_name()%></td>
										<td class="viewsubject" >신청자:<%=BranchList.get(i).getId()%></td>		
										
									
								</tr>
									<tr style="padding: 15px 15px 22px 15px; border-bottom: 1px solid #d5d8dd;padding-left: 40px;">
										<td class="viewsubject" >전화번호:<%=BranchList.get(i).getBranch_tel()%></td>	
									<td class="viewform" colspan="1" >이름:<%=BranchList.get(i).getName()%></td>
								
									
										
									
								</tr>
							
								<tr style="border-bottom: 2px solid #2c3c57;border-bottom: 2px solid #2c3c57;">
									
									
									<td class="viewform" style="height: 50px;">
										주소: <%=BranchList.get(i).getBranch_location()%>
									</td>
									<td class="viewform" ><span style="float:right"><input type="button" id="button" class="signbutton signbutton5" value="구장등록" onclick="location.href='ground.jsp?branch_name=<%=BranchList.get(0).getBranch_name()%>&branch_no=<%=BranchList.get(0).getBranch_no()%>'"/>
										</span>
									</td>
								</tr>
									<% 
									}
								%>
								
							</table>
						
							<div>
							<form name="branchRepInsert" class="form" method="post" action="adminBranchRepPro.adm?command=adminBranchRepPro " role="form" autocomplete="off" style=" height: 130px;">
							<div id="rep"style="height: 15px;">
								<textarea name="branch_rep_contents" id="branch_rep_contents"rows="7"
										style="resize: none; width: 1034px;height: 100px;"cols="40"; ></textarea></div>
								<input type="submit" id="repSubmit" class="signbutton signbutton5" value="저장" style="height: 100px;padding-left: 15px;width: 99px;padding-right: 15px;font-size: 16px;"/>
				                <input type="hidden" name="branch_no" value="<%=BranchList.get(0).getBranch_no() %>" style="position:fixed;" />
								<input type="hidden" name="name" value="<%=name %>" style="position:fixed;" />
								<input type="hidden" id="branch_state" name=branch_state style="position:fixed;" value="<%=BranchList.get(0).getBranch_state()%>"/>
								
								
							</form>
														<div id="innerRep">
									<div style="height: 400px;overflow-y:scroll;   ">					
								<table class="table table-condensed"  style="background: #e0e0e05c;">
								<%
									for(int i=0; i<AdminBranchRepList.size(); i++){
								%>	
										<tr>
												<td id="repId"><strong> 담당자: </strong>  
												 <%=AdminBranchRepList.get(i).getName() %></td>
											<td id="repDate"><%=AdminBranchRepList.get(i).getBranch_rep_date() %></td>
										
											</tr>
										
											<tr>	<td id="repContents"><textarea rows="4" cols="145" readonly="readonly"><%=AdminBranchRepList.get(i).getBranch_rep_contents() %></textarea></td>
										</tr>
								<% 
									}
								%>
							
							</table>
				</div>
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
