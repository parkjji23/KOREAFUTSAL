package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LeagueDto;
import model.LeagueResultDto;
import model.LeagueResult_Action;
import model.LeagueResult_Action2;
import model.League_allselect_Action;
import model.PlayerRegistDto;

public class League_main_Service implements Cominterface {
	static League_main_Service impl = new League_main_Service();

	public static League_main_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("리그메인서비스");
//		LeagueList_Action leaguemodel = LeagueList_Action.instance();
//		ArrayList<LeagueDto> LeagueList = (ArrayList<LeagueDto>) leaguemodel.getLeagueList();
		League_allselect_Action leagueallmodel = League_allselect_Action.instance();
		ArrayList<LeagueDto> LeagueAllList = (ArrayList<LeagueDto>) leagueallmodel.getLeagueall();
		LeagueResult_Action2 leagueresultmodel = LeagueResult_Action2.instance();
		
		String league_codeString = request.getParameter("lcode");
		
		ArrayList<LeagueResultDto> LeagueResultList = new ArrayList<LeagueResultDto>();
		ArrayList<PlayerRegistDto> LeagueplayerList = new ArrayList<PlayerRegistDto>();
		if(league_codeString!=null) {
			int league_code = Integer.parseInt(league_codeString);
			LeagueResultList = (ArrayList<LeagueResultDto>) leagueresultmodel.getLeagueResult(league_code);
			LeagueplayerList = (ArrayList<PlayerRegistDto>) leagueresultmodel.getLeaguePlayer(league_code);
		}else {
			LeagueResultList = (ArrayList<LeagueResultDto>) leagueresultmodel.getLeagueResult(LeagueAllList.get(0).getLeague_code());
			LeagueplayerList = (ArrayList<PlayerRegistDto>) leagueresultmodel.getLeaguePlayer(LeagueAllList.get(0).getLeague_code());
		}
		
		
		
		request.setAttribute("LeagueAllList", LeagueAllList);
		request.setAttribute("LeagueResultList", LeagueResultList);
		request.setAttribute("LeagueplayerList", LeagueplayerList);
		return "league.jsp";

	}
}