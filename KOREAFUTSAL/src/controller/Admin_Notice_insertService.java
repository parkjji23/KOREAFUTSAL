package controller;

import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NoticeboardDto;
import model.NoticeboardList_Action;
import model.TeamDto;
import model.TeamRegistAction;



public class Admin_Notice_insertService implements Cominterface {

	static Admin_Notice_insertService impl = new Admin_Notice_insertService();

	public static Admin_Notice_insertService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("확인중2");
		response.setContentType("text/html;charset=UTF-8");
		
		String n_title = request.getParameter("n_title");
		
		n_title = new String(n_title.getBytes("8859_1"), "utf-8");
		System.out.println("확인중2"+n_title);
		String n_contents = request.getParameter("n_contents");
		n_contents = new String(n_contents.getBytes("8859_1"), "utf-8");
		System.out.println("확인중2"+n_contents);
		String admin_name = request.getParameter("admin_name");
		admin_name = new String(admin_name.getBytes("8859_1"), "utf-8");
		System.out.println("확인중2"+admin_name);
		String n_state = request.getParameter("n_state");
		n_state = new String(n_state.getBytes("8859_1"), "utf-8");
		System.out.println("확인중2"+n_state);
		
		
		NoticeboardDto NoticeDto = new NoticeboardDto();
		
		NoticeDto.setAdmin_name(admin_name);
		NoticeDto.setN_contents(n_contents);
		NoticeDto.setN_title(n_title);
		NoticeDto.setN_state(n_state);
		System.out.println("확인중3"+NoticeDto.getAdmin_name());
		System.out.println("확인중3"+NoticeDto.getN_contents());
		System.out.println("확인중3"+NoticeDto.getN_title());
		System.out.println("확인중3"+NoticeDto.getN_state());
		
		NoticeboardList_Action model = NoticeboardList_Action.instance();
		request.setCharacterEncoding("UTF-8");

		NoticeboardList_Action Noticeboardmodel = NoticeboardList_Action.instance();
		Noticeboardmodel.noticeboard_insert(NoticeDto);
		
		ArrayList<NoticeboardDto> NoticeboardList = (ArrayList<NoticeboardDto>) Noticeboardmodel.getNoticeboardList();

		request.setAttribute("NoticeboardList", NoticeboardList);
		return "admin_notice.jsp";


	
	}

}
