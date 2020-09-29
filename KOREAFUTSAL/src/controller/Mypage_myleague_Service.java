package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LeagueandLeagueResultDto;
import model.Mypage_myteam_Action;
import model.TeamDto;

public class Mypage_myleague_Service implements Cominterface{
	static Mypage_myleague_Service impl = new Mypage_myleague_Service();

	public static Mypage_myleague_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		Mypage_myteam_Action MypageAction = Mypage_myteam_Action.instance();
		ArrayList<LeagueandLeagueResultDto> myleaguelist = (ArrayList<LeagueandLeagueResultDto>) MypageAction.getmyleagueinfo(id);
		
		request.setAttribute("myleaguelist", myleaguelist);
		return "myleague.jsp";

	}

}
