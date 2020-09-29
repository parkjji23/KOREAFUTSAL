package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NoticeboardDto;
import model.NoticeboardList_Action;


public class Admin_NoticeboardList_Service implements Cominterface {
	static Admin_NoticeboardList_Service impl = new Admin_NoticeboardList_Service();

	public static Admin_NoticeboardList_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		NoticeboardList_Action Noticeboardmodel = NoticeboardList_Action.instance();
		ArrayList<NoticeboardDto> NoticeboardList = (ArrayList<NoticeboardDto>) Noticeboardmodel.getNoticeboardList();

		request.setAttribute("NoticeboardList", NoticeboardList);
		return "admin_notice.jsp";

	}

}
