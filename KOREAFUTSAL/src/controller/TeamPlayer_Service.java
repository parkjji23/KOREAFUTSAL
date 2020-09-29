package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDto;
import model.PlayerRegistDto;
import model.PlayerRegist_Action;


public class TeamPlayer_Service implements Cominterface {
	static TeamPlayer_Service impl = new TeamPlayer_Service();

	public static TeamPlayer_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TeamPlayer_Service.java 접근");
		request.setCharacterEncoding("UTF-8");
		int t_code = Integer.parseInt(request.getParameter("teamcode"));
		PlayerRegistDto Player = new PlayerRegistDto();
		
		Player.setT_code(t_code);
		
		System.out.println("팀 코드 "+t_code);
		PlayerRegist_Action playerlist = PlayerRegist_Action.instance();	
		ArrayList<PlayerRegistDto> PlayerList =  (ArrayList<PlayerRegistDto>) playerlist.getPlayerList(Player);
		ArrayList<MemberDto> MemberList =  (ArrayList<MemberDto>) playerlist.getMemberList(Player);
		System.out.println("멤버리스트사이즈"+MemberList.size());
		System.out.println("플레이어리스트사이즈"+PlayerList.size());
		request.setAttribute("PlayerList", PlayerList);
		request.setAttribute("MemberList", MemberList);
		System.out.println("TeamPlayer_Service에 입력 성공");
		return "team_players.jsp";

	}
}
