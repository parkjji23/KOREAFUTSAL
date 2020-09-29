package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeamBoardListAction;
import model.TeamBoardListDto;
import model.TeamBoardListWriteformAction;
import model.TeamDto;
import vo.PageInfo;

public class TeamboardListWriteformService implements Cominterface {
	static TeamboardListWriteformService impl = new TeamboardListWriteformService();

	public static TeamboardListWriteformService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int page=1;
		int limit=10;
		String id = request.getParameter("id");
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		TeamBoardListWriteformAction teamBoardListWriteformAction = TeamBoardListWriteformAction.instance();
		ArrayList<TeamDto> teamlist = (ArrayList<TeamDto>)teamBoardListWriteformAction.getTeamList(id);
		
		
		
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		
   		
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		
		
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("teamlist", teamlist);
		request.setAttribute("pageInfo", pageInfo);
		
		return "team_board_list_writeform.jsp";

	}

}