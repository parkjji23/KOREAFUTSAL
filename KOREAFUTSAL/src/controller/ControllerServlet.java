package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComResInfoDto;
import model.GroundDto;

public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		Cominterface inter = null;
		String viewName = "";

		try {
			if(command.equals("index")){	//�ε���
				System.out.println("�ε�����Ʈ�ѷ�����");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = Index_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("idcheck")) {	//ȸ������������ ���̵��ߺ�Ȯ�� ajax
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = ConfirmIdService.instance();;
				String count = inter.showData(request, response);
				
				String id = request.getParameter("id");
				if(count.equals("123")) {
					out.println(id + "��(��) �̹� ������� ID�Դϴ�");
				}else {
					out.println(id + "��(��)����� �� �ִ�  ID�Դϴ�");
				}
			}
			else if (command.equals("loginbutton")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = LoginService.instance();
				viewName = inter.showData(request, response);
				int check=(int)request.getAttribute("check");
				String loginChk = request.getParameter("loginchk");
				String loginid = request.getParameter("username");
				System.out.println(loginChk+"��Ű üũ �� �����°�");
				if(check==0) {
					out.println("<script>alert('���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.');</script>");
				}else {
					
					if (loginChk != null) { // üũ�� ���
						Cookie c = new Cookie("id", loginid);
						c.setMaxAge(60*60);;
						c.setPath("/");
						response.addCookie(c);
					}
					out.println("ok");
					out.println("<script>alert('�α��ο������Ͽ����ϴ�.')</script>");
				}
			} else if (command.equals("signinput")) {	//ȸ������
				System.out.println("������ǲ��Ʈ�ѷ�");
				response.setContentType("text/html;charset=UTF-8");
				inter = SigninsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===========���������� ��Ʈ�ѷ�========================================================================
			else if(command.equals("mypage")){	//���������� ȸ������������������
				System.out.println("111");
				inter = SignImpl.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("pwchange")){	//���������� ��й�ȣ ����
				inter = PwModify.instance();
				inter.showData(request, response);
				//request.getRequestDispatcher("sangpum_insert.jsp").forward(request, response);
			}
			else if(command.equals("signmodify")){	//���������� ȸ����������
				inter = SignModify.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}else if(command.equals("signdel")){//���������� ȸ��Ż��
				System.out.println("��Ʈ�ѷ�����");
				inter = SignDel.instance();
				viewName = inter.showData(request, response);
				PrintWriter out=response.getWriter();
				int check=(int) request.getAttribute("check");
				System.out.println(check);
				if(check==0) {
					out.println("<script>alert('��й�ȣ�� Ȯ�����ּ���.')</script>");
				}else {
					out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.')</script>");
				}
			}
			//=============���������� ��Ʈ�ѷ� ��====================================================================
			//������������Ʈ�ѷ� �߰�03.27//
			else if(command.equals("mypageteam_click")){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = Mypage_myteam_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("mypageleague_click")){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = Mypage_myleague_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//=============���������� ��Ʈ�ѷ� 
			//==============��������� ��Ʈ�ѷ�=====================================================================
			else if(command.equals("branchlistview")){
				System.out.println("��Ʈ�ѷ�����");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = BranchList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("branchdetail")){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = BranchDetail_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("qna")){  //qna ����Ʈ ���
				System.out.println("qna ����Ʈ ���");
				inter = QnaList_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
//			else if(command.equals("qnasearch")){  //qna �˻� ���
//				System.out.println("qna �˻� ���");
//				inter = QnaSearch.instance();
//				viewName = inter.showData(request, response);		
//				request.getRequestDispatcher(viewName).forward(request, response);
//			}
			else if (command.equals("reservationclick")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = ReservationClick_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("reservation_input")) { // ǲ���� ���
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Reservation_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} 
			else if (command.equals("selectground")) { // reservation.jsp
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = SelectgroundService.instance();
				String count = inter.showData(request, response);
				ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) request.getAttribute("data");
				if (count.equals("123")) {
					out.println("[ {" + "\"clickground_no\": '" + GroundList.get(0).getGround_no() + "',"
							+ "\"weekAM_charge\": '" + GroundList.get(0).getGround_weekdaydaytime_charge() + "',"
							+ "\"weekPM_charge\": '" + GroundList.get(0).getGround_weekdaynight_charge() + "',"
							+ "\"weekendAM_charge\": '" + GroundList.get(0).getGround_weekenddaytime_charge() + "',"
							+ "\"weekendPM_charge\": '" + GroundList.get(0).getGround_weekendnight_charge() + "'" + "}"
							+ "]");
				}
			}
			else if (command.equals("reservation_list")) { // ���������ȸ
				response.setContentType("text/html;charset=UTF-8");
				inter = ReservationList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("payment_input")) { // Paymentpage.jsp [resmaxno]
				response.setContentType("text/html;charset=UTF-8");
				inter = Paymentpage_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("resstatus_update")) { // res_status ����Ϸ�10->�����Ϸ�20
				response.setContentType("text/html;charset=UTF-8");
				inter = Res_statusService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("paymentsuccess")) { // �����Ϸ� select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = PaymentsuccessService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("delete_reservation")) { // �����Ϸ� select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = DeleteReservation_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("mypagestatuschange")) { // �����Ϸ� select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = Mypage_statusService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("Radiohidden")) { // ������� ������ư ��������� ��ü��������ҷ�����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = ReservationhiddenService.instance();
				String count_hidden = inter.showData(request, response);
				ArrayList<ComResInfoDto> ComResInfoList = (ArrayList<ComResInfoDto>) request.getAttribute("data");
				if (count_hidden.equals("789")) {
					out.println("{\"Dateout\":[");
					for(int i=0;i<ComResInfoList.size();i++) {
					out.println("{" + "\"choiceground_name\": '" + ComResInfoList.get(i).getGround_name() + "',"
							+ "\"choiceground_no\": '" + ComResInfoList.get(i).getGround_no() + "',"
							+ "\"choicebranch_name\": '" + ComResInfoList.get(i).getBranch_name() + "',"
							+ "\"choicebranch_no\": '" + ComResInfoList.get(i).getBranch_no() + "',"
							+ "\"completed_date\": '" + ComResInfoList.get(i).getRes_date() + "',"
							+ "\"completed_time\": '" + ComResInfoList.get(i).getRes_time() + "'" + "}");	
					if(ComResInfoList.size() > 1) {
						out.println(",");
					}
					}
					out.println("]}");
				}
			}else if (command.equals("datepicker_selecthidden")) { // �޷´����� ������ư7���� selectbox ����,<->//
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = DatepickerSelectHiddenService.instance();
				String count_hidden = inter.showData(request, response);
				ArrayList<ComResInfoDto> ComResInfoList = (ArrayList<ComResInfoDto>) request.getAttribute("data");
				if (count_hidden.equals("789")) {
					out.println("{\"Datecount\":[");
					for(int i=0;i<ComResInfoList.size();i++) {
					out.println("{" + "\"choiceground_no\": '" + ComResInfoList.get(i).getGround_no() + "',"
							+ "\"choiceground_name\": '" + ComResInfoList.get(i).getGround_name() + "',"
							+ "\"COUNTS\": '" + ComResInfoList.get(i).getRadiocount() + "'" + "}");	
					if(ComResInfoList.size() > 1) {
						out.println(",");
					}
					}
					out.println("]}");
				}
			}
			
			
			//===========��������� ��Ʈ�ѷ� ��=======================================================================
			//==========���Խ�����Ʈ�ѷ�===========================================================================
			else if(command.equals("teamboardlist")){  //���Խ������
				System.out.println("���Խ�����Ʈ�ѷ�");
				inter = TeamBoardListService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_board_list_writeform")){  //���Խ��Ǳ۾����������ΰ���
				System.out.println("���Խ��Ǳ۾���������");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamboardListWriteformService.instance();
				viewName = inter.showData(request, response);
				//viewName = "team_board_list_writeform.jsp";
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_board_list_write")){  	//���Խ��Ǳ۾���
				System.out.println("���Խ��Ǳ۾���");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamboardListWriteService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboarddetail")){  //���Խ��ǻ󼼺���
				System.out.println("teamboarddetail");
				inter = TeamBoardDetail_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardrepinsert")){  //���Խ��Ǵ��
				System.out.println("teamboardrepinsert");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamBoardRepInsert_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardmodifyform")){  //���Խ��Ǽ����ϴ��������ΰ���
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboardmodifyform_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardmodify")){  	//���Խ��Ǽ���
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboardmodify_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboarddelete")){  	//���Խ��ǻ���
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboarddelete_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===========���Խ�����Ʈ�ѷ� ��===============================================================================
			//===========���׸���, ��������,���׼������ ��Ʈ�ѷ�========================================================================
			else if(command.equals("league_main")){  //���׸���������
				System.out.println("���׸�����Ʈ�ѷ�");
				response.setContentType("text/html;charset=UTF-8");
				inter = League_main_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_join_step1")){  //���� ���� ��� ����1
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step1_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_join_step2")){  //���� ���� ��� ����2
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step2_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leaguestep2teamcheck")) { // ���� ���� ��� ����2���� ��û����Ȯ��
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = League_join_teamcheck_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("��Ʈ�ѷ��������� true�� ������ : "+leagueteamresult);
				if (leagueteamresult.equals("true")) {
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "ture" + "\'"
							+ "}" + "]");
				}else if(leagueteamresult.equals("true+")) {
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "ture+" + "\'"
							+ "}" + "]");
				}
			}
			else if(command.equals("league_join_step3")){  	//���� ���� ��� ����3
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step3_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_team_step1")){  	//���� �� ���� ����1
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step1_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_team_step2")){  	//���� �� ���� ����2
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step2_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leagueteamstep2teamcheck")) { // ���� �� ���� ����2���� �������� Ȯ��
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = League_team_teamcheck_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("��Ʈ�ѷ��������� true�� ������ : "+leagueteamresult);
				if (leagueteamresult.equals("true")) { //�̹� ���׿� ���� ���� ��ϵǾ�����
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "true" + "\'"
							+ "}" + "]");
				}else {
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "false" + "\'"
							+ "}" + "]");
				}
			}
			else if(command.equals("league_team_step3")){  		//���� �� ���� ����3
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step3_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leaderCheck")) { // ���׿� ��������û�Ҷ� �������� Ȯ��
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = LeaderCheck_Service.instance();
				String count = inter.showData(request, response);
				if (count.equals("10")) {
					out.println("leader");
				}
			}
			
			else if (command.equals("matchapply")) { // ��ġ�Խ��� �ҷ�����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Matchapply_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			else if (command.equals("yonglist")) { // �뺴�Խ��� �ҷ�����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Yonglist_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
//			else if (command.equals("findid")) { // 
//				response.setContentType("text/html;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				inter = FindId_Service.instance();
//				viewName = inter.showData(request, response);
//				request.getRequestDispatcher(viewName).forward(request, response);
//				
//			}
			else if (command.equals("match_apply_reg")) { // ��ġ��û �ҷ�����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = match_apply_reg_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			else if (command.equals("groundsearchWhbranch")) { // ��ġ��û���� ������ ������ �������� �������� ajax
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = GroundsearchWhbranch_Service.instance();
				inter.showData(request, response);
				ArrayList<GroundDto> groundlist = (ArrayList<GroundDto>) request.getAttribute("groundlist");
				if(!groundlist.isEmpty()) {
					out.println("{\"groundlist\":[");
					for(int i=0;i<groundlist.size();i++) {
					out.println("{" + "\"ground_no\": " + groundlist.get(i).getGround_no() + ","
							+ "\"ground_name\": \"" + groundlist.get(i).getGround_name() + "\"}");
					if(groundlist.size() > i+1) {
						out.println(",");
					}
					}
					out.println("]}");
				}
			}
			else if (command.equals("yongsign")) { // �뺴��� �ҷ�����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Yongsign_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			//=======================���׸���, ��������,���׼������ ��Ʈ�ѷ� ��============================================================
			//=======================��������������Ʈ�ѷ�====================================================================
			else if(command.equals("teamlist")){  //������Ʈ  ���
				System.out.println("teamlist ���");
				inter = TeamListView_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teaminfo")){  //������ ���
				System.out.println("teaminfo ���");
				inter = TeamInfoService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_regist")){  //����� 
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamRegistService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_modify")){  //������  ���
				System.out.println("team modify ���");
				inter = TeamModifyService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamsearch")){  //������Ʈ �˻�  ���
				System.out.println("team search ���");
				inter = TeamSearchService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamranking")){  //����ŷ  ���
				System.out.println("team ranking ���");
				inter = TeamRanking_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamplayer")){  //���������  ���
				System.out.println("team player ���");
				inter = TeamPlayer_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamapplyer")){  //�����Խ�û���  ���
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				System.out.println("team applyer List ���");
				inter = TeamApplyList_Service.instance();
				String leaderresult = inter.showData(request, response);		
				System.out.println("��Ʈ�ѷ��������� true�� ������ : "+leaderresult);
				if (leaderresult.equals("true")) {
					out.println(
							"[ {" 
							+ "\"leaderteamresult\": \'" + "true" + "\'"
							+ "}" + "]");
				}
			}
			else if(command.equals("teamjoin")){  //���Խ�û ���� ����
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				System.out.println("team join ���� ���� ���");
				inter = Team_Join_Service.instance();
				inter.showData(request, response);						
			}
			else if (command.equals("teamcheck")) { 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Team_apply_check_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("��Ʈ�ѷ��������� true�� ������ : "+leagueteamresult);
				if (leagueteamresult.equals("false")) {
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "false" + "\'"
							+ "}" + "]");
				}
				else if(leagueteamresult.equals("false+")) {
					out.println(
							"[ {" 
							+ "\"leagueteamresult\": \'" + "false+" + "\'"
							+ "}" + "]");
				}
			}
			else if(command.equals("teamapply")){  //�����Խ�û���  ���
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("team apply ���");
				PrintWriter out=response.getWriter();
				inter = TeamApply_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teammodifyform")){  //������  ���
				System.out.println("team modify form ���");
				inter = TeamModifyFormService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===================������������ ��Ʈ�ѷ� ��=======================================================
			//==================������������ ��Ʈ�ѷ�==========================================================
			else if (command.equals("groundlistview2")) { // 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BranchList_Service2.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("noticeboard")) { // 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = NoticeboardList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("noticeboard_view")) { // 
				System.out.println("!");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = NoticeboardList_Service2.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("branchcheck")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = ConfirmbranchService.instance();
				String count = inter.showData(request, response);
				System.out.println(count);
				String branch_name = request.getParameter("branch_name");
				System.out.println(branch_name);

				if (count.equals("123")) {
					out.println(branch_name + "");
				} else {
					out.println(branch_name + "");
				}
			} else if (command.equals("groundcheck")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = ConfirmgroundService.instance();
				String count = inter.showData(request, response);
				String ground_name = request.getParameter("ground_name");

				if (count.equals("123")) {
					out.println(ground_name + "");
				} else {
					out.println(ground_name + "");
				}
			}
			else if (command.equals("branch")) { //�������

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BrabchinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//================������������ ��Ʈ�ѷ� ��===========================================================
			else {
				viewName = "error.jsp";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
	}
}
