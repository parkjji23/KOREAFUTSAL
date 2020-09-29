<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String url = (String) session.getAttribute("url");
	request.setCharacterEncoding("UTF-8");
	session.removeAttribute("url");
	session.removeAttribute("id");
	session.removeAttribute("pw");
	session.removeAttribute("name");
	session.removeAttribute("email");
	session.removeAttribute("tel");
	Cookie[] c = request.getCookies();
	if (c != null) {
		for (Cookie cf : c) {
			if (cf.getName().equals("id")) {
				cf.setMaxAge(0);
				cf.setPath("/");
				response.addCookie(cf);
			}
		}
	}
	if (url.equals("/logincom.jsp")) {
		response.sendRedirect("index.do?command=index");
	} else if (url.equals("/signdel.jsp")) {
		response.sendRedirect("index.do?command=index");
	} else {
		response.sendRedirect(request.getHeader("referer"));
	}
%>
