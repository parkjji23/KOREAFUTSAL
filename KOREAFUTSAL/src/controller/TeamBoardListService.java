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
		//우측 팀 눌렀을때 넘어오는 팀코드이다. 해당 팀의 글만 select하기위해 가져온다.
		String t_code = request.getParameter("teamcode");
		if(t_code!=null)
			if(t_code.equals("null")) {
				System.out.println("팀코드의null은 String이다!!!!");
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

		System.out.println("---------가져온페이지정보입니다---------");
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
//			System.out.println("글씨null");
//			teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardList(page);
//			listCount = teamboardlistaction.getListCount();
//		}else {
//			teamboardlist = (ArrayList<TeamBoardListDto>) teamboardlistaction.getTeamBoardListTeam(page,t_code);
//			listCount = teamboardlistaction.getListCountteam(t_code);
//		}
		
		//화면 우측에 팀리스트 가져오기
		TeamList_Action teamList_Action = TeamList_Action.instance();
		ArrayList<TeamDto> teamlist = (ArrayList<TeamDto>) teamList_Action.getTeamList(teamPageDto);
		
		
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+1); //0.95를 더해서 올림 처리.
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
		request.setAttribute("teamboardlist", teamboardlist);
		request.setAttribute("teamlist", teamlist);
		request.setAttribute("t_code", t_code);
		request.setAttribute("teamname", teamname);
		
		ArrayList<NoticeboardDto> noticelist = new ArrayList<NoticeboardDto>();
		String a = "팀게시판 공지사항";
		System.out.println("a는 =?"+a);
		noticelist = (ArrayList<NoticeboardDto>) teamboardlistaction.getnoticelist(a);
		request.setAttribute("noticelist", noticelist);
		
		return "team_board_list.jsp";

	}

}
