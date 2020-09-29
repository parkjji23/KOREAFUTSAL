package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.omg.CORBA.Request;

import model.AdminDto;
import model.AdminLoginAction;
import model.BranchDetail_Action;
import model.BranchDto;
import model.LoginAction;
import model.MemberDetail_Action;
import model.MemberDto;
import model.SigninsertAction;

public class AdminMemberListService implements Cominterface {
	static AdminMemberListService impl = new AdminMemberListService();

	public static AdminMemberListService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("»±¿Œ2");
	
		HttpSession session = request.getSession();
			System.out.println("»Æ¿Œ");		
			MemberDetail_Action memberdetailmodel = MemberDetail_Action.instance();
		ArrayList<MemberDto> MemberList = (ArrayList<MemberDto>) memberdetailmodel.getBranchList2();
		request.setAttribute("MemberList", MemberList);

		return"adminmemberlist.jsp";
	}
}