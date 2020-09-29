package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin_QnAList_Action;
import vo.QnaDto;

public class Admin_QnADetail_Service implements Cominterface {
	static Admin_QnADetail_Service impl = new Admin_QnADetail_Service();

	public static Admin_QnADetail_Service instance() {
		return impl;

	}


	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int q_b_no=Integer.parseInt(request.getParameter("q_b_no"));
		Admin_QnAList_Action qnalistaction = Admin_QnAList_Action.instance();
		ArrayList<QnaDto> QnaDetaillist = (ArrayList<QnaDto>) qnalistaction.Qnaviewdetail(q_b_no);

		request.setAttribute("QnaDetaillist", QnaDetaillist);
		return "admin_qnadetail_view.jsp";
	}
}
