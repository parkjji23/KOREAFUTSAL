package controller;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ApplyList_Action;
import model.MemberDto;
import model.PlayerRegistDto;



public class TeamApplyList_Service implements Cominterface {
	static TeamApplyList_Service impl = new TeamApplyList_Service();

	public static TeamApplyList_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TeamApplyList_Service.java ����");
	
		request.setCharacterEncoding("UTF-8");
		PlayerRegistDto Player = new PlayerRegistDto();
		String leader = (String)request.getParameter("leader");
		
		System.out.println("����üũ��� ���"+leader);
		int t_code = Integer.parseInt(request.getParameter("team_code"));
		
		String id=request.getParameter("id");

		String leaderresult="false";
		Player.setT_code(t_code);
		Player.setId(id);
		
		System.out.println("���Խ�û ���� �ڵ� "+t_code);
		System.out.println("������ ���̵�: "+id);
		ApplyList_Action applyer = ApplyList_Action.instance();	
		ArrayList<PlayerRegistDto> Leader =  (ArrayList<PlayerRegistDto>) applyer.getLeader(Player);
		System.out.println(Leader.get(0).getId());
		if(Leader.get(0).getId()!=null) {
			ArrayList<PlayerRegistDto> Applyer =  (ArrayList<PlayerRegistDto>) applyer.getApplyer(Player);
			System.out.println("getApplyer �޼ҵ� ����Ϸ�");
//			for(int i=0;i<Applyer.size();i++) {
//				System.out.println(i+"��° ������"+Applyer.get(i).getId());
//			}
			ArrayList<MemberDto> Member =  (ArrayList<MemberDto>) applyer.getMember(Player);
			HttpSession session=request.getSession();
			session.setAttribute("Applyer",Applyer);
			session.setAttribute("Member",Member);
			System.out.println("TeamApplyer_Service�� �Է� ����");
			leaderresult="true";
		}
		return leaderresult;
	}
}
