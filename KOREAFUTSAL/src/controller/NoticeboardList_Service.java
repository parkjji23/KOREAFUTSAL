

package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.BranchList_Action;
import model.NoticeboardDto;
import model.NoticeboardList_Action;


public class NoticeboardList_Service implements Cominterface {
	static NoticeboardList_Service impl = new NoticeboardList_Service();

	public static NoticeboardList_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
        String a= "공지사항";
		NoticeboardList_Action Noticeboardmodel = NoticeboardList_Action.instance();
		ArrayList<NoticeboardDto> NoticeboardList = (ArrayList<NoticeboardDto>) Noticeboardmodel.getNoticeboardList(a);

		request.setAttribute("NoticeboardList", NoticeboardList);
		return "notice.jsp";

	}

}
