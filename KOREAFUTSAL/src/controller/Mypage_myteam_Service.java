package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDetail_Action;
import model.BranchDto;
import model.BranchList_Action;
import model.GroundDto;
import model.Mypage_myteam_Action;
import model.TeamDto;

public class Mypage_myteam_Service implements Cominterface{
	static Mypage_myteam_Service impl = new Mypage_myteam_Service();

	public static Mypage_myteam_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		Mypage_myteam_Action MypageAction = Mypage_myteam_Action.instance();
		ArrayList<TeamDto> myteamlist = (ArrayList<TeamDto>) MypageAction.getmyteaminfo(id);
		
		request.setAttribute("myteamlist", myteamlist);
		return "myteam.jsp";

	}

}
