
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

public class AdminBranchListService implements Cominterface {
	static AdminBranchListService impl = new AdminBranchListService();

	public static AdminBranchListService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("2");
	
		HttpSession session = request.getSession();
			System.out.println("");		
		BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchList2();
		request.setAttribute("BranchList", BranchList);

		return"adminQ.jsp";
	}
}
