
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
			if (command.equals("adminloginbutton")) { // ���� ���� �α��� + ������Ȳ����
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
			} else if (command.equals("admin_BranchList")) { // ��ܸ޴� - ������Ȳ ����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminBranchListService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("admin_BranchList_view")) { // ��ܸ޴� - ������Ȳ - �󼼺��� ����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_BranchList_view_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("adminBranchRepPro")) { //��ܸ޴� - ������Ȳ  - �󼼺��� / ���� ��㳻��
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminBrabchRepinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("admin_MemberList_view")) { // ��ܸ޴� - ȸ������ ����Ʈ ����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = AdminMemberListService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("admin_member_view")) { // ��� �ڼ�������
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_Member_view_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("notice")) { //��ܸ޴� - �������� ����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Admin_NoticeboardList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("notice_insert")){  //��ܸ޴� - �������� - �������� ��� 
				System.out.println("Ȯ����1");
				response.setContentType("text/html;charset=UTF-8");
				inter = Admin_Notice_insertService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("noticeboard_view")) { //��ܸ޴� - �������� - �ڼ�������
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
			//������������ �߰�_0402 ����//
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