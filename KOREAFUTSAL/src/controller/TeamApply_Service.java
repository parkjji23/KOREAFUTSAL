package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlayerApply_Action;
import model.PlayerRegistDto;



public class TeamApply_Service implements Cominterface {
	static TeamApply_Service impl = new TeamApply_Service();

	public static TeamApply_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TeamApply_Service.java ����");
		String id = request.getParameter("id");
		request.setCharacterEncoding("UTF-8");
		int t_code = Integer.parseInt(request.getParameter("teamcode"));
		PlayerRegistDto Player = new PlayerRegistDto();
		Player.setT_code(t_code);
		Player.setId(id);
		System.out.println("��û�ϴ� ���� �ڵ� "+t_code+"����� ID"+id);
		
		PlayerApply_Action applyer = PlayerApply_Action.instance();	
		applyer.getApplyer(Player);
		System.out.println("getApplyer �޼ҵ� ����Ϸ�");
		System.out.println("TeamApplyer_Service�� �Է� ����");
		return "teamlist.do?command=teamlist";

	}
}
