
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminControllerServlet extends HttpServlet {

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		Cominterface inter = null;
		String viewName = "";
		System.out.println("commadns is???" + command);
		try {
			if (command.equals("adminloginbutton")) { // 어드민 계정 로그인 + 지점현황연결
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("");
				PrintWriter out = response.getWriter();
				inter = AdminLoginService.instance();
				viewName = inter.showData(request, response);
				System.out.println("?" + viewName);
				// request.getRequestDispatcher(viewName).forward(request, response);
				int check = (int) request.getAttribute("check");
				if (check == 0) {
					out.println("<script>alert('');</script>");
					request.getRequestDispatcher(viewName).forward(request, response);

				} else {

					request.getRequestDispatcher(viewName).forward(request, response);
				}
			} else if (command.equals("admin_BranchList")) { // 상단메뉴 - 지점현황 연결
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminBranchListService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("admin_BranchList_view")) { // 상단메뉴 - 지점현황 - 상세보기 연결
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_BranchList_view_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("adminBranchRepPro")) { //상단메뉴 - 지점현황  - 상세보기 / 지점 상담내용
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminBrabchRepinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("admin_MemberList_view")) { // 상단메뉴 - 회원정보 리스트 연결
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminMemberListService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("admin_member_view")) { // 멤버 자세히보기
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_Member_view_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("notice")) { //상단메뉴 - 공지사항 연결
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_NoticeboardList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("notice_insert")){  //상단메뉴 - 공지사항 - 공지사항 등록 
				System.out.println("확인중1");
				response.setContentType("text/html;charset=UTF-8");
				inter = Admin_Notice_insertService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("noticeboard_view")) { //상단메뉴 - 공지사항 - 자세히보기
				System.out.println("!");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_NoticeboardList_view_Service.instance();
				viewName = inter.showData(request, response);
				System.out.println(viewName);
				request.getRequestDispatcher(viewName).forward(request, response);
			}

			else if (command.equals("branch")) { //

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BrabchinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("ground")) {
				System.out.println(command + "1");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = GroundinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}

			else if (command.equals("branchlistview")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BranchList_Service.instance();
				viewName = inter.showData(request, response);
				// request.getRequest(viewName).forward(request, response);
			} else if (command.equals("groundlistview2")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BranchList_Service2.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("branchdetail")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BranchDetail_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} 
			//관리자페이지 추가_0402 지은//
			else if (command.equals("AdminQnaList")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_QnAList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("AdminQnADetail")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_QnADetail_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("qnaSendEmail")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = SendEmail.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			///////////////////////
			else {
				viewName = "error.jsp";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
	}
}