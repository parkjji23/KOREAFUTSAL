package controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.AdminBrabchRepinsertAction;
import model.AdminBranchRepDto;
import model.BrabchinsertAction;
import model.BranchDetail_Action;
import model.BranchDto;

public class AdminBrabchRepinsertService implements Cominterface {

	static AdminBrabchRepinsertService impl = new AdminBrabchRepinsertService();

	public static AdminBrabchRepinsertService instance() {
		
		return impl;

		
		
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("진입1");
	
		String branch_no = request.getParameter("branch_no");
		branch_no = new String(branch_no.getBytes("8859_1"), "utf-8");
		System.out.println("확인중2");
		System.out.println("넘버는?"+branch_no);
		int branch_no1 =Integer.parseInt(request.getParameter("branch_no"));
		System.out.println("지점 넘버는?"+ branch_no1);
		
		String branch_state =request.getParameter("branch_state");
		branch_state = new String(branch_state.getBytes("8859_1"), "utf-8");
		System.out.println("상태는?"+branch_state);
		
		
		
		String branch_rep_contents =request.getParameter("branch_rep_contents");
		branch_rep_contents = new String(branch_rep_contents.getBytes("8859_1"), "utf-8");
		System.out.println(branch_rep_contents);
		
		String name =request.getParameter("name");
		name = new String(name.getBytes("8859_1"), "utf-8");
		System.out.println("이름은??"+name);
		
		
		
	
		
		
		
		
		

		AdminBranchRepDto AdminBranchRepDto = new AdminBranchRepDto();
		AdminBranchRepDto.setBranch_no(branch_no1);
		AdminBranchRepDto.setBranch_rep_contents("["+branch_state+"]"+branch_rep_contents);
		AdminBranchRepDto.setName(name);
		
		

		AdminBrabchRepinsertAction model = AdminBrabchRepinsertAction.instance();
		
		model.insertinform(AdminBranchRepDto);
		
		BranchDto BranchDto = new BranchDto();
		BranchDto.setBranch_no(branch_no1);
		BranchDto.setBranch_state(branch_state);
		
		
		BrabchinsertAction model2 = BrabchinsertAction.instance();
		
		model2.insertinform2(BranchDto);
		
		
		///////////////////////////
		
		
		BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
	    ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchDetail(branch_no);
	   	request.setAttribute("BranchList", BranchList);
	   	System.out.println("확인중3");
	   	
	   	AdminBrabchRepinsertAction BrabchRepmodel = AdminBrabchRepinsertAction.instance();
	    ArrayList<AdminBranchRepDto> AdminBranchRepList = (ArrayList<AdminBranchRepDto>) BrabchRepmodel.getAdminBranchRep(branch_no);
	   	request.setAttribute("AdminBranchRepList", AdminBranchRepList);
	   	
	   	
	   	
	   	
	   	
	   	
		System.out.println(request.getAttribute("BranchList")); 
		return "admin_branch_view.jsp";
		
		
		
		
		
		
		

//		
//		////////////////////////////////////////////
//		HttpSession session = request.getSession();
//		System.out.println("확인");		
//	BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
//	ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchList2();
//	request.setAttribute("BranchList", BranchList);
//
//	return"adminQ.jsp";
	}

} 
