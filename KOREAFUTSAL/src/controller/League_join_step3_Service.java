package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.League_join_step3_Action;
import model.PlayerRegistDto;

public class League_join_step3_Service implements Cominterface {
	static League_join_step3_Service impl = new League_join_step3_Service();

	public static League_join_step3_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("서비스옴");
		int t_code = Integer.parseInt(request.getParameter("team_code"));
		System.out.println(1);
		int league_code = Integer.parseInt(request.getParameter("league_code"));
		int player_uniformnum = Integer.parseInt(request.getParameter("uniformnum"));
		String player_position = request.getParameter("position");
		String id = request.getParameter("id");
		System.out.println(t_code);
		System.out.println(league_code);
		System.out.println(id);
		PlayerRegistDto playerRegistDto = new PlayerRegistDto();
		playerRegistDto.setId(id);
		playerRegistDto.setLeague_code(league_code);
		playerRegistDto.setT_code(t_code);
		playerRegistDto.setPlayer_uniformnum(player_uniformnum);
		playerRegistDto.setPlayer_position(player_position);
		
		
		
		
		League_join_step3_Action registmodel = League_join_step3_Action.instance();
		int playerregistresult1 = registmodel.playerregist(playerRegistDto);
		
//		League_BranchList_Action leaguebranchmodel = League_BranchList_Action.instance();
//		ArrayList<BranchDto> LeagueBranchList = (ArrayList<BranchDto>) leaguebranchmodel.getLeagueBranchList();
		if(playerregistresult1>0) {
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('선수등록을 완료했습니다.');location.href='league.do?command=league_main'; </script>");
			 
			out.flush();
		}
			
		
		
		request.setAttribute("playerregistresult1", playerregistresult1);
		return "league.do?command=league_main";

	}
}