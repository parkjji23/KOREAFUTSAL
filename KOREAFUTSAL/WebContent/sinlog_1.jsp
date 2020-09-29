<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


<!DOCTYPE html>
<html>


<head>
<title>로그인</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/sinlog.css">




<script type='text/javascript'>
	function loginajax() {
		//alert("");
		$.ajax({
			type : "post",
			url : "./adminlogin.adm?command=adminloginbutton",
			data : {
				
				admin_id : $('#admin_id').val(),
				admin_password : $('#admin_password').val()
			},
			success : whenSuccesslogin,
			error : whenErrorlogin
		});
	}
	function whenSuccesslogin(resdata) {

		$("#LoginAjax").html(resdata);

		if (resdata.includes("ok")) { //includes= 특정요소가 있냐  /includes("ok") =ok라는 문자가있냐?

			location.replace("adminQ.jsp"); //replace=새로고침 /location.replace("adminQ.jsp") =새로고침하면서 ()안에주소로이동
		}

		else { alert("실패");

		}
	}
	function whenErrorlogin() {
		alert("Error");
	}
</script>


</head>
<body>
	
	<div class="login-form">
		<form name="admin" method="post" id="admin"
			action="adminlogin.adm?command=adminloginbutton">
			<div class="text-1">그린풋살</div>
			<input type="text" name="admin_id" class="text-field"
				placeholder="아이디"><br> <input type="password"
				name="admin_password" class="text-field" placeholder="비밀번호"><br>
			<input type="submit" value="로그인" class="submit-btn"
				onclick="loginajax()">
		</form>
		<div id="LoginAjax"></div>
	</div>
</body>
</html>