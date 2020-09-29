package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminBrabchRepinsertAction;
import model.AdminBranchRepDto;
import model.BranchDetail_Action;
import model.BranchDto;
import model.BranchList_Action2;
import model.GroundDto;

public class Admin_BranchList_view_Service implements Cominterface {
	static Admin_BranchList_view_Service impl = new Admin_BranchList_view_Service();

	public static Admin_BranchList_view_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String branch_no = request.getParameter("branch_no");
		System.out.println("2");
		System.out.println(""+branch_no);

		BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
	    ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchDetail(branch_no);
	   	request.setAttribute("BranchList", BranchList);
	   	System.out.println("3");
	   	
	   	AdminBrabchRepinsertAction BrabchRepmodel = AdminBrabchRepinsertAction.instance();
	    ArrayList<AdminBranchRepDto> AdminBranchRepList = (ArrayList<AdminBranchRepDto>) BrabchRepmodel.getAdminBranchRep(branch_no);
	   	request.setAttribute("AdminBranchRepList", AdminBranchRepList);
	   	
	   	
	   	
	   	
	   	
	   	
		System.out.println(request.getAttribute("BranchList")); 
		return "admin_branch_view.jsp";

	}
}
