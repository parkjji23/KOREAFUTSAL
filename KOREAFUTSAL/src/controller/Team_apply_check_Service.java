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
		System.out.println("���Ǿ��̵�: "+id);
		System.out.println("�������ڵ�: "+t_code);
		String playerteamresult="false";
		PlayerRegistDto player = new PlayerRegistDto();
		player.setT_code(t_code);	
		player.setId(id);
		Team_apply_check_Action teammodel = Team_apply_check_Action.instance();
		playerapplycheck = (ArrayList<PlayerRegistDto>)teammodel.playerapplycheck(player);
		playerteamcheck = (ArrayList<PlayerRegistDto>)teammodel.playerteamcheck(player);
		if(!playerteamcheck.isEmpty())
			System.out.println("���������ڵ��ֳ� : "+playerteamcheck.get(0).getT_code());
		
		if(!playerteamcheck.isEmpty()) {//����ڰ� �̹� �� �ÿ� ���ԵǾ��ִ� ���
			playerteamresult="true";
		}else {							//����ڰ� �ش����� ������ �ȵǾ��ִ� ���
			playerteamresult="false";
		}
		if(!playerapplycheck.isEmpty()) { //�̹� ���Խ�û�� �� ���
			playerteamresult+="+";
			System.out.println(playerapplycheck+"�̹� ���Խ�û�� �Ѱ�쿡�� ����̸� �� �ȿ� �����...");
		}
		
		
		return playerteamresult;

	}
}