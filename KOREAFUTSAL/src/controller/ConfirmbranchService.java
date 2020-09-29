
package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.ConfirmIdAction;
import model.ConfirmbranchAction;
import model.MemberDto;

public class ConfirmbranchService implements Cominterface {

	static ConfirmbranchService impl = new ConfirmbranchService();

	public static ConfirmbranchService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String branch_name = request.getParameter("branch_name");
		 System.out.println("구장명은?"+branch_name);
		 ConfirmbranchAction model = ConfirmbranchAction.instance();
		ArrayList<BranchDto> checkuser = (ArrayList<BranchDto>) model.selectbrabch(branch_name);
		request.setAttribute("data", checkuser);
		String count="";
		
		if(checkuser.isEmpty()) {
			
			count="456";
            System.out.println(count);
		} else {
			
			count="123";
			   System.out.println(count);
		}
         
		return count;
	}

}
