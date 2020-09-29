package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin_QnAList_Action;
import vo.QnaDto;

public class Admin_QnAList_Service implements Cominterface {
	static Admin_QnAList_Service impl = new Admin_QnAList_Service();

	public static Admin_QnAList_Service instance() {
		return impl;

	}


	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		Admin_QnAList_Action qnalistaction = Admin_QnAList_Action.instance();
		ArrayList<QnaDto> Qnalist = (ArrayList<QnaDto>) qnalistaction.Qnaviewlist();
		System.out.println(Qnalist.get(0).getQ_b_contents()+"ehehehehhe");

		request.setAttribute("Qnalist", Qnalist);
		return "admin_qnalist_view.jsp";
	}
}
