package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PlayerRegistDto;
import model.Team_Join_Action;



public class Team_Join_Service implements Cominterface {
	static Team_Join_Service impl = new Team_Join_Service();

	public static Team_Join_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Team_Join_Service.java 접근");
		PrintWriter out = response.getWriter();
		String leaderresult="false";
		
		request.setCharacterEncoding("UTF-8");
		PlayerRegistDto Player = new PlayerRegistDto();
		int t_code = Integer.parseInt(request.getParameter("team_code"));	
		String id=request.getParameter("id");
		int req = Integer.parseInt(request.getParameter("req"));
		System.out.println("1혹은2 잘 가져와?  "+req);
		
		Player.setT_code(t_code);
		Player.setId(id);
		
		System.out.println("가입신청 팀의 코드 "+t_code);
		System.out.println("접속자 아이디: "+id);
		Team_Join_Action applyer = Team_Join_Action.instance();	
		
		if(req==1) {
		 applyer.approval(Player);
			
			out.println(
					"[ {" 
					+ "\"leaderteamresult\": \'" + "true" + "\'"
					+ "}" + "]");
		}
		else {
			applyer.refusal(Player);
		
			out.println(
					"[ {" 
					+ "\"leaderteamresult\": \'" + "false" + "\'"
					+ "}" + "]");
		}
		return leaderresult;
	}
}
