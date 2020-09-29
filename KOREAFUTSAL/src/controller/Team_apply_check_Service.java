package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LeagueResultDto;
import model.Team_apply_check_Action;
import model.PlayerRegistDto;

public class Team_apply_check_Service implements Cominterface {
	static Team_apply_check_Service impl = new Team_apply_check_Service();

	public static Team_apply_check_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ArrayList<PlayerRegistDto> playerapplycheck = null;
		ArrayList<PlayerRegistDto> playerteamcheck = null;
		int t_code=Integer.parseInt(request.getParameter("team_code"));
		String id=request.getParameter("id");
		System.out.println("앞의아이디: "+id);
		System.out.println("앞의팀코드: "+t_code);
		String playerteamresult="false";
		PlayerRegistDto player = new PlayerRegistDto();
		player.setT_code(t_code);	
		player.setId(id);
		Team_apply_check_Action teammodel = Team_apply_check_Action.instance();
		playerapplycheck = (ArrayList<PlayerRegistDto>)teammodel.playerapplycheck(player);
		playerteamcheck = (ArrayList<PlayerRegistDto>)teammodel.playerteamcheck(player);
		if(!playerteamcheck.isEmpty())
			System.out.println("가져온팀코드있냐 : "+playerteamcheck.get(0).getT_code());
		
		if(!playerteamcheck.isEmpty()) {//사용자가 이미 그 팅에 가입되어있는 경우
			playerteamresult="true";
		}else {							//사용자가 해당팀에 가입이 안되어있는 경우
			playerteamresult="false";
		}
		if(!playerapplycheck.isEmpty()) { //이미 가입신청을 한 경우
			playerteamresult+="+";
			System.out.println(playerapplycheck+"이미 가입신청을 한경우에만 출력이며 그 안에 결과가...");
		}
		
		
		return playerteamresult;

	}
}