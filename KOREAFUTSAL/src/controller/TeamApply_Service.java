package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlayerApply_Action;
import model.PlayerRegistDto;



public class TeamApply_Service implements Cominterface {
	static TeamApply_Service impl = new TeamApply_Service();

	public static TeamApply_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TeamApply_Service.java 접근");
		String id = request.getParameter("id");
		request.setCharacterEncoding("UTF-8");
		int t_code = Integer.parseInt(request.getParameter("teamcode"));
		PlayerRegistDto Player = new PlayerRegistDto();
		Player.setT_code(t_code);
		Player.setId(id);
		System.out.println("신청하는 팀의 코드 "+t_code+"당신의 ID"+id);
		
		PlayerApply_Action applyer = PlayerApply_Action.instance();	
		applyer.getApplyer(Player);
		System.out.println("getApplyer 메소드 실행완료");
		System.out.println("TeamApplyer_Service에 입력 성공");
		return "teamlist.do?command=teamlist";

	}
}
