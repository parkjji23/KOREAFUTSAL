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
import model.MemberDetail_Action;
import model.MemberDto;

public class Admin_Member_view_Service implements Cominterface {
	static Admin_Member_view_Service impl = new Admin_Member_view_Service();

	public static Admin_Member_view_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		System.out.println("확인중222222222222222222");
		System.out.println("아이디는??"+id);


	   	
	   	MemberDetail_Action memberdetailmodel = MemberDetail_Action.instance();
	    ArrayList<MemberDto> MemberList = (ArrayList<MemberDto>) memberdetailmodel.getMemberDetail(id);
	   	request.setAttribute("MemberList", MemberList);
	   	System.out.println("확인중3");
	   	
	   	
		System.out.println(request.getAttribute("MemberList")); 
		return "admin_member_view.jsp";

	}
}
