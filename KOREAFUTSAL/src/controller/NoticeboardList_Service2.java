

package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.BranchList_Action;
import model.NoticeboardDto;
import model.NoticeboardList_Action;


public class NoticeboardList_Service2 implements Cominterface {
	static NoticeboardList_Service2 impl = new NoticeboardList_Service2();

	public static NoticeboardList_Service2 instance() {
		return impl;

	}


	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		
		int n_num=Integer.parseInt(request.getParameter("n_num"));
		
		NoticeboardDto NoticeDto = new NoticeboardDto();

		NoticeDto.setN_num(n_num);
		
		NoticeboardList_Action Noticeboardmodel = NoticeboardList_Action.instance();
		ArrayList<NoticeboardDto> NoticeboardList2 = (ArrayList<NoticeboardDto>) Noticeboardmodel.getNoticeboardList2(n_num);
		Noticeboardmodel.noticeboard_readcount(NoticeDto);

		request.setAttribute("NoticeboardList2", NoticeboardList2);
		return "notice_view.jsp";

	}
}
