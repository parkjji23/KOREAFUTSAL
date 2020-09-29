package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.BranchList_Action;
import model.League_BranchList_Action;

public class match_apply_reg_Service implements Cominterface {
	static match_apply_reg_Service impl = new match_apply_reg_Service();

	public static match_apply_reg_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		BranchList_Action branchList_Action = BranchList_Action.instance();
		ArrayList<BranchDto> branchList = (ArrayList<BranchDto>) branchList_Action.getBranchList();
		request.setAttribute("branchList", branchList);
		return "match_apply_reg.jsp";

	}
}