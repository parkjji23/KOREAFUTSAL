package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.BranchList_Action;

public class Yongsign_Service implements Cominterface {
	static Yongsign_Service impl = new Yongsign_Service();

	public static Yongsign_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		BranchList_Action branchList_Action = BranchList_Action.instance();
		ArrayList<BranchDto> branchList = (ArrayList<BranchDto>) branchList_Action.getBranchList();
		request.setAttribute("branchList", branchList);
		return "matyong_yongsign.jsp";

	}
}