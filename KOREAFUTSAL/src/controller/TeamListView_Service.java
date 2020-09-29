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
		System.out.println("TeamListView_Service.java ����");
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
		
		System.out.println("���� : "+teamType);
		System.out.println("---------�����������������Դϴ�---------");
		System.out.println(teamPageDto.getPage());
		System.out.println(teamPageDto.getKeyword());
		System.out.println(teamPageDto.getSearchType());
		
		System.out.println("--------------------------------");
		ArrayList<TeamDto> TeamList = (ArrayList<TeamDto>) teamlistmodel.getTeamList(teamPageDto);
		System.out.println(TeamList.size());
		listCount = teamlistmodel.getListCount(teamPageDto);
		ArrayList<TeamDto> RegistPlayer = (ArrayList<TeamDto>) teamlistmodel.getRegistPlayer();
		
		//�� ������ ��.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
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
