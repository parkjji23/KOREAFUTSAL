package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LeagueResultDto;
import model.League_team_step3_Action;
import model.PlayerRegistDto;

public class League_team_step3_Service implements Cominterface {
	static League_team_step3_Service impl = new League_team_step3_Service();

	public static League_team_step3_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("서비스옴");
		int t_code = Integer.parseInt(request.getParameter("team_code"));
		int league_code = Integer.parseInt(request.getParameter("league_code"));
		
		
		String id = request.getParameter("id");
		System.out.println(t_code);
		System.out.println(league_code);
		System.out.println(id);
		PlayerRegistDto playerRegistDto = new PlayerRegistDto();
		playerRegistDto.setId(id);
		playerRegistDto.setLeague_code(league_code);
		playerRegistDto.setT_code(t_code);
		
		LeagueResultDto leagueResultDto = new LeagueResultDto();
		
		leagueResultDto.setLeague_code(league_code);
		leagueResultDto.setT_code(t_code);
		
		
		
		League_team_step3_Action registmodel = League_team_step3_Action.instance();
		int teamregistresult1 = registmodel.teamregist(playerRegistDto,leagueResultDto);
		
//		League_BranchList_Action leaguebranchmodel = League_BranchList_Action.instance();
//		ArrayList<BranchDto> LeagueBranchList = (ArrayList<BranchDto>) leaguebranchmodel.getLeagueBranchList();
		if(teamregistresult1>0) {
		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('리그접수에 성공했습니다.'); location.href='league.do?command=league_main';</script>");
		 
		out.flush();
		}
		
		
		request.setAttribute("teamregistresult1", teamregistresult1);
		return "league.do?command=league_main";

	}
}