package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.BranchDto;
import model.BranchList_Action;
import model.LeagueResultDto;
import model.NoticeboardDto;
import model.TeamBoardListAction;
import model.TeamBoardListDto;
import model.TeamDto;
import model.TeamList_Action;
import model.TeamPageDto;
import vo.PageInfo;

public class TeamBoardListService implements Cominterface {
	static TeamBoardListService impl = new TeamBoardListService();

	public static TeamBoardListService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int page=1;
		int limit=10;
		int listCount=1;
		ArrayList<TeamBoardListDto> teamboardlist = new ArrayList<TeamBoardListDto>();
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		int startrow = (page - 1) * 9;
		//���� �� �������� �Ѿ���� ���ڵ��̴�. �ش� ���� �۸� select�ϱ����� �����´�.
		String t_code = request.getParameter("teamcode");
		if(t_code!=null)
			if(t_code.equals("null")) {
				System.out.println("���ڵ���null�� String�̴�!!!!");
				t_code=null;
			}
		String teamname = request.getParameter("teamname");
		String searchType = request.getParameter("searchtype");
		String search = request.getParameter("search");
		if(search!=null)
			search= new String(search.getBytes("8859_1"), "utf-8");
		
		TeamBoardListAction teamboardlistaction = TeamBoardListAction.instance();
		
		TeamPageDto teamPageDto = new TeamPageDto();
		teamPageDto.setPage(startrow);
		teamPageDto.setKeyword(search);
		teamPageDto.setT_code(t_code);
		teamPageDto.setSearchType(searchType);

		System.out.println("---------�����������������Դϴ�---------");
		System.out.println(teamPageDto.getPage());
		System.out.println(teamPageDto.getKeyword());
		System.out.println(teamPageDto.getT_code());
		System.out.println(teamPageDto.getSearchType());
		System.out.println("--------------------------------");
		
		
		teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardList(teamPageDto);
		listCount = teamboardlistaction.getListCount(teamPageDto);
		
		
//		if(t_code==null) {
//			if(searchtype==null) {
//				teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardList(page);
//				listCount = teamboardlistaction.getListCount();
//			}else if(searchtype.equals("all")) {
//				teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardListsearchall(page,search);
//				listCount = teamboardlistaction.getListCountsearchall(search);
//			}else if(searchtype.equals("subject")) {
//				teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardListsearchsubject(page,search);
//				listCount = teamboardlistaction.getListCountsearchsubject(search);
//			}else {
//				teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardListsearchuser(page,search);
//				listCount = teamboardlistaction.getListCountsearchuser(search);
//			}
//		}else if(t_code.equals("null")){
//			System.out.println("�۾�null");
//			teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardList(page);
//			listCount = teamboardlistaction.getListCount();
//		}else {
//			teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardListTeam(page,t_code);
//			listCount = teamboardlistaction.getListCountteam(t_code);
//		}
		
		//ȭ�� ������ ������Ʈ ��������
		TeamList_Action teamList_Action = TeamList_Action.instance();
		ArrayList<TeamDto> teamlist = (ArrayList<TeamDto>) teamList_Action.getTeamList(teamPageDto);
		
		
		//�� ������ ��.
   		int maxPage=(int)((double)listCount/limit+1); //0.95�� ���ؼ� �ø� ó��.
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
		request.setAttribute("teamboardlist", teamboardlist);
		request.setAttribute("teamlist", teamlist);
		request.setAttribute("t_code", t_code);
		request.setAttribute("teamname", teamname);
		
		ArrayList<NoticeboardDto> noticelist = new ArrayList<NoticeboardDto>();
		String a = "���Խ��� ��������";
		System.out.println("a�� =?"+a);
		noticelist = (ArrayList<NoticeboardDto>) teamboardlistaction.getnoticelist(a);
		request.setAttribute("noticelist", noticelist);
		
		return "team_board_list.jsp";

	}

}
