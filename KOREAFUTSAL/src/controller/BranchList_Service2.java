
package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.BranchList_Action2;
import model.GroundDto;

public class BranchList_Service2 implements Cominterface {
	static BranchList_Service2 impl = new BranchList_Service2();

	public static BranchList_Service2 instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println("가져온아이디는?"+id);

		BranchList_Action2 branchmodel = BranchList_Action2.instance();
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchmodel.getBranchList(id);

		request.setAttribute("BranchList", BranchList);
		return "ground.jsp";

	}
}
