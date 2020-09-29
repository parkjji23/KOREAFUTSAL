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
import model.SigninsertAction;

public class AdminLoginService implements Cominterface {
	static AdminLoginService impl = new AdminLoginService();

	public static AdminLoginService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("2");
		String aa;
		String redirectPage = request.getParameter("uri");
		String urr = request.getHeader("referer"); // 

		String login_admin_id = request.getParameter("admin_id");
		System.out.println("3"+login_admin_id);
		String login_admin_password = request.getParameter("admin_password");
		System.out.println("3-1"+login_admin_password);
		HttpSession session = request.getSession();
		
		AdminDto AdminDto = new AdminDto();
		AdminDto.setAdmin_id(login_admin_id);
		System.out.println("4"+AdminDto.getAdmin_id());
		AdminDto.setAdmin_password(login_admin_password);
		System.out.println("4-1"+AdminDto.getAdmin_password());
		
		
		
		
		AdminLoginAction loginmodel = AdminLoginAction.instance();
		
		ArrayList<AdminDto> loginadmin = (ArrayList<AdminDto>) loginmodel.login(AdminDto);
		
		request.setAttribute("data", loginadmin);
		if (!loginadmin.isEmpty()) { //isEmpty =    !loginadmin.isEmpt = loginadmin?
			System.out.println("");
			
			
			String admin_id = loginadmin.get(0).getAdmin_id();
			System.out.println(""+admin_id);
			String admin_password = loginadmin.get(0).getAdmin_password();
			System.out.println(""+admin_password);
			String admin_name = loginadmin.get(0).getAdmin_name();
			String admin_Number = loginadmin.get(0).getAdmin_Number(); //�씤�듃�삎�엫
			String position = loginadmin.get(0).getPosition();
		
			
			session.setAttribute("admin_id", admin_id);
			//String admin_id2 = (String) session.getAttribute("admin_id");
			//System.out.println(""+admin_id2);
			session.setAttribute("admin_password", admin_password);
			//String admin_password2 = (String) session.getAttribute("admin_password");
		    //System.out.println(""+admin_password);
			session.setAttribute("admin_name", admin_name);
			session.setAttribute("admin_Number", admin_Number);
			session.setAttribute("position", position);
			
			System.out.println(11111111);
			request.setAttribute("check", 1);
			System.out.println(2222222);
			aa="adminQ.jsp";
		} else {System.out.println("");
			request.setAttribute("check", 0);
			//aa=urr;
			aa="sinlog_1.jsp";
		}
		
		BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchList2();
		request.setAttribute("BranchList", BranchList);
		
		BranchDetail_Action branchdetailmodel2 = BranchDetail_Action.instance(); //?
		ArrayList<BranchDto> BranchList2 = (ArrayList<BranchDto>) branchdetailmodel.getBranchList2();
		request.setAttribute("BranchList", BranchList);

		return aa;
	}
}
