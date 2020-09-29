<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>footer 이어붙이세용</title>
<link rel="stylesheet" type="text/css" href="css\footer.css" />
<style>
.whitebar{
    display: inline-block;
       margin-right: 43px;
    width: 1px;
    height: 13px;
    background: #e8e9ec;
    vertical-align: -2px;
}

.graybar{
    display: inline-block;
    margin-left: 14px;
    margin-right: 14px;
    width: 1px;
    height: 20px;
    background: #969696;
    vertical-align: -2px;
}

.linklist li {
    color: #888;
    vertical-align: top;
    letter-spacing: -1px;
    font-size: 15px;
    line-height: 12px;
}

.creators{
    color: #969696;
    font-size: 16px;
    font-weight:bold;
    display:flex;
        letter-spacing: 2px;
}

.academytitle{
    color: #969696;
    font-size: 17px;
    font-weight:bold;
}
</style>
</head>
<body>
	<div id="footerdesign" STYLE="    height: 215px;">
		<img src="img/FooterLogo.jpg" style="margin-left:230px; margin-top: 88px;">
		<div id="footerlink">
		<ul class="linklist" style="margin-top:40px;margin-left:-75px;display:flex;place-content: space-around;width:600px;">
		<li><a href="introduce_page.jsp" style="text-decoration: none;color:white;">홈페이지소개</a></li>
		<li><span class="whitebar"></span><a href="branch.jsp" style="text-decoration: none;color:white;">지점등록신청</a></li>
		<li><span class="whitebar"></span><a href="servicecenter.do?command=qna" style="text-decoration: none;color:white;">고객센터</a></li>
		<li><span class="whitebar"></span><a href="sinlog_1.jsp" style="text-decoration: none;color:white;">관리자</a></li>
		</ul>
		</div>

		<div id="footertext" style="margin-left: 670px;    width: 709px;    margin-top: 21px;">
			<div class="creators">KIM KWANG-HO<span class="graybar"></span>PARK JI-EUN<span class="graybar"></span>LEE JONG-HYEOK<span class="graybar"></span>JUNG MOON-GYUNG</div></br>
		</div>
		<div class="academytitle"style="margin-top:25px;    margin-left: 871px;letter-spacing: 3px;">GREEN COMPUTER ACADEMY</div>
	</div>
</body>
</html>