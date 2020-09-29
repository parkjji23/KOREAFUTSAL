package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeamDto;
import model.TeamList_Action;
import model.TeamPageDto;
import vo.PageInfo;

public class TeamListView_Service implements Cominterface {
	static TeamListView_Service impl = new TeamListView_Service();

	public static TeamListView_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TeamListView_Service.java 접근");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int page=1;
		int limit=10;
		int listCount=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		int startrow = (page - 1) * 9;
		String teamType = request.getParameter("teamtype");
		String search = request.getParameter("search");
		if(search!=null)
			search= new String(search.getBytes("8859_1"), "utf-8");
		TeamList_Action teamlistmodel = TeamList_Action.instance();
		TeamPageDto teamPageDto = new TeamPageDto();
		teamPageDto.setPage(startrow);
		teamPageDto.setKeyword(search);
		teamPageDto.setSearchType(teamType);
		
		System.out.println("구분 : "+teamType);
		System.out.println("---------가져온페이지정보입니다---------");
		System.out.println(teamPageDto.getPage());
		System.out.println(teamPageDto.getKeyword());
		System.out.println(teamPageDto.getSearchType());
		
		System.out.println("--------------------------------");
		ArrayList<TeamDto> TeamList = (ArrayList<TeamDto>) teamlistmodel.getTeamList(teamPageDto);
		System.out.println(TeamList.size());
		listCount = teamlistmodel.getListCount(teamPageDto);
		ArrayList<TeamDto> RegistPlayer = (ArrayList<TeamDto>) teamlistmodel.getRegistPlayer();
		
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;
   		
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("TeamList", TeamList);
		request.setAttribute("RegistPlayer", RegistPlayer);
		return "team_list.jsp";

	}
}
