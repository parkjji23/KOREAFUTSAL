package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LeaderCheck_Action;
import model.TeamDto;

public class LeaderCheck_Service implements Cominterface{
	
	static LeaderCheck_Service impl = new LeaderCheck_Service();

	public static LeaderCheck_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String id = request.getParameter("id");
		 
		 LeaderCheck_Action model = LeaderCheck_Action.instance();
			ArrayList<TeamDto> leadercheckteam = (ArrayList<TeamDto>) model.leadercheck(id);
			
			String count="";
			
			if(leadercheckteam.isEmpty()) {
				System.out.println("������ ��ϵ� ���� �����ϴ�.");
				count="20";

			} else {
				System.out.println("�����Դϴ�.");
				count="10";
			}

			return count;
		}
}