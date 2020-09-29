<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.YonglistDto"%>
<%@ page import="java.util.Date"%>
<%@page import="dao.YonglistDao"%>
<%request.setCharacterEncoding("UTF-8");%>



	<jsp:useBean id ="yl" class="dao.YonglistDao"/>
	<jsp:useBean id="yongnew" class="vo.YonglistDto"/>
	<jsp:setProperty name="yongnew" property="*"/>
	

		<%
		String function = request.getParameter("fn");
		String id =request.getParameter("id");
		if(function.equals("1")){
		yl.insert(yongnew);
		}
		else{
			yl.update(yongnew);
		}
		response.sendRedirect("matyong.do?command=yonglist");
		%>
	
	
	
