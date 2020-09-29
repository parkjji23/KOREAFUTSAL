package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeamDto;
import model.TeamModifyFormAction;


public class TeamModifyFormService implements Cominterface {

	static TeamModifyFormService impl = new TeamModifyFormService();

	public static TeamModifyFormService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("TeamModifyForm_Service.java 접근");
		request.setCharacterEncoding("UTF-8");
		int teamcode = Integer.parseInt(request.getParameter("teamcode"));
		TeamDto TeamDto = new TeamDto();
		TeamDto.setT_code(teamcode);
		TeamModifyFormAction model = TeamModifyFormAction.instance();
		ArrayList<TeamDto>list =(ArrayList<TeamDto>)model.getTeamList(TeamDto);
		request.setAttribute("TeamList", list);
		System.out.println("수정완료");
		
		return "team_modi_form.jsp";
	}

}
