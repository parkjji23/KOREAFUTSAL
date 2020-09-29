package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDetail_Action;
import model.GroundDto;
import model.LeagueResultDto;
import model.League_join_teamcheck_Action;

public class GroundsearchWhbranch_Service implements Cominterface {
	static GroundsearchWhbranch_Service impl = new GroundsearchWhbranch_Service();

	public static GroundsearchWhbranch_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String branch_no=request.getParameter("branch_no");
		System.out.println(branch_no);
		
		
		BranchDetail_Action branchDetail_Action = BranchDetail_Action.instance();
		ArrayList<GroundDto> groundlist = (ArrayList<GroundDto>) branchDetail_Action.getGroundDetail(branch_no);
		
		
		request.setAttribute("groundlist", groundlist);
		
		
		return "";

	}
}