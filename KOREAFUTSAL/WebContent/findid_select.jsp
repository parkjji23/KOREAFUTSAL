<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String em1 = request.getParameter("em1");
String em2 = request.getParameter("em2");
String email = em1+"@"+em2;

String result = null;

Connection conn = null;
Statement stmt = null;
try{
  Class.forName("com.mysql.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/koreafutsal?useSSL=false&useUnicode=true&characterEncoding=utf8", "koreafutsal", "korea34811005");
   stmt = conn.createStatement();
   String s = "select * from member_tb where NAME='"+name+"' and EMAIL='"+email+"';";
   ResultSet rs = stmt.executeQuery(s); 
   out.println(s);
   if (rs.next()){
	   String id = rs.getString("id");

	   request.setAttribute("id",id);
	   
	   RequestDispatcher dispatcher = request.getRequestDispatcher("findid_success.jsp");
	   dispatcher.forward(request,response);
   }else {
	   out.println("<script>alert('입력하신 회원정보가 존재하지 않습니다.'); history.back();</script>");
   }
}finally {
	try{
		stmt.close();
	}catch (Exception ignored) {
	}
	try {
		conn.close();
	}catch (Exception ignored) {
	}
	}
%>
<body>

</body>