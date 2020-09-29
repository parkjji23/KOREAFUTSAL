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
			if(command.equals("index")){	//인덱스
				System.out.println("인덱스컨트롤러들어옴");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = Index_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("idcheck")) {	//회원가입페이지 아이디중복확인 ajax
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				inter = ConfirmIdService.instance();;
				String count = inter.showData(request, response);
				
				String id = request.getParameter("id");
				if(count.equals("123")) {
					out.println(id + "는(은) 이미 사용중인 ID입니다");
				}else {
					out.println(id + "는(은)사용할 수 있는  ID입니다");
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
				System.out.println(loginChk+"쿠키 체크 값 들어오는가");
				if(check==0) {
					out.println("<script>alert('아이디나 비밀번호가 일치하지 않습니다.');</script>");
				}else {
					
					if (loginChk != null) { // 체크한 경우
						Cookie c = new Cookie("id", loginid);
						c.setMaxAge(60*60);;
						c.setPath("/");
						response.addCookie(c);
					}
					out.println("ok");
					out.println("<script>alert('로그인에성공하였습니다.')</script>");
				}
			} else if (command.equals("signinput")) {	//회원가입
				System.out.println("사인인풋컨트롤러");
				response.setContentType("text/html;charset=UTF-8");
				inter = SigninsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===========마이페이지 컨트롤러========================================================================
			else if(command.equals("mypage")){	//마이페이지 회원정보수정페이지로
				System.out.println("111");
				inter = SignImpl.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("pwchange")){	//마이페이지 비밀번호 변경
				inter = PwModify.instance();
				inter.showData(request, response);
				//request.getRequestDispatcher("sangpum_insert.jsp").forward(request, response);
			}
			else if(command.equals("signmodify")){	//마이페이지 회원정보수정
				inter = SignModify.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}else if(command.equals("signdel")){//마이페이지 회원탈퇴
				System.out.println("컨트롤러진입");
				inter = SignDel.instance();
				viewName = inter.showData(request, response);
				PrintWriter out=response.getWriter();
				int check=(int) request.getAttribute("check");
				System.out.println(check);
				if(check==0) {
					out.println("<script>alert('비밀번호를 확인해주세요.')</script>");
				}else {
					out.println("<script>alert('삭제가 완료되었습니다.')</script>");
				}
			}
			//=============마이페이지 컨트롤러 끝====================================================================
			//마이페이지컨트롤러 추가03.27//
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
			//=============마이페이지 컨트롤러 
			//==============대관페이지 컨트롤러=====================================================================
			else if(command.equals("branchlistview")){
				System.out.println("컨트롤러들어옴");
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
			else if(command.equals("qna")){  //qna 리스트 출력
				System.out.println("qna 리스트 출력");
				inter = QnaList_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
//			else if(command.equals("qnasearch")){  //qna 검색 출력
//				System.out.println("qna 검색 출력");
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
			else if (command.equals("reservation_input")) { // 풋살장 대관
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
			else if (command.equals("reservation_list")) { // 대관내역조회
				response.setContentType("text/html;charset=UTF-8");
				inter = ReservationList_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("payment_input")) { // Paymentpage.jsp [resmaxno]
				response.setContentType("text/html;charset=UTF-8");
				inter = Paymentpage_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("resstatus_update")) { // res_status 예약완료10->결제완료20
				response.setContentType("text/html;charset=UTF-8");
				inter = Res_statusService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("paymentsuccess")) { // 결제완료 select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = PaymentsuccessService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("delete_reservation")) { // 결제완료 select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = DeleteReservation_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("mypagestatuschange")) { // 결제완료 select ***
				response.setContentType("text/html;charset=UTF-8");
				inter = Mypage_statusService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if (command.equals("Radiohidden")) { // 대관에서 라디오버튼 숨기기위한 전체대관내역불러오기
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
			}else if (command.equals("datepicker_selecthidden")) { // 달력누를때 라디오버튼7개면 selectbox 숨김,<->//
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
			
			
			//===========대관페이지 컨트롤러 끝=======================================================================
			//==========팀게시판컨트롤러===========================================================================
			else if(command.equals("teamboardlist")){  //팀게시판출력
				System.out.println("팀게시판컨트롤러");
				inter = TeamBoardListService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_board_list_writeform")){  //팀게시판글쓰기페이지로가기
				System.out.println("팀게시판글쓰기폼으로");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamboardListWriteformService.instance();
				viewName = inter.showData(request, response);
				//viewName = "team_board_list_writeform.jsp";
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_board_list_write")){  	//팀게시판글쓰기
				System.out.println("팀게시판글쓰기");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamboardListWriteService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboarddetail")){  //팀게시판상세보기
				System.out.println("teamboarddetail");
				inter = TeamBoardDetail_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardrepinsert")){  //팀게시판댓글
				System.out.println("teamboardrepinsert");
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamBoardRepInsert_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardmodifyform")){  //팀게시판수정하는페이지로가기
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboardmodifyform_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboardmodify")){  	//팀게시판수정
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboardmodify_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamboarddelete")){  	//팀게시판삭제
				response.setContentType("text/html;charset=UTF-8");
				inter = Teamboarddelete_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===========팀게시판컨트롤러 끝===============================================================================
			//===========리그메인, 리그접수,리그선수등록 컨트롤러========================================================================
			else if(command.equals("league_main")){  //리그메인페이지
				System.out.println("리그메인컨트롤러");
				response.setContentType("text/html;charset=UTF-8");
				inter = League_main_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_join_step1")){  //리그 선수 등록 스텝1
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step1_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_join_step2")){  //리그 선수 등록 스텝2
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step2_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leaguestep2teamcheck")) { // 리그 선수 등록 스텝2에서 신청여부확인
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = League_join_teamcheck_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("컨트롤러에가져온 true는 있을까 : "+leagueteamresult);
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
			else if(command.equals("league_join_step3")){  	//리그 선수 등록 스텝3
				response.setContentType("text/html;charset=UTF-8");
				inter = League_join_step3_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_team_step1")){  	//리그 팀 접수 스텝1
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step1_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("league_team_step2")){  	//리그 팀 접수 스텝2
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step2_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leagueteamstep2teamcheck")) { // 리그 팀 접수 스텝2에서 접수여부 확인
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = League_team_teamcheck_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("컨트롤러에가져온 true는 있을까 : "+leagueteamresult);
				if (leagueteamresult.equals("true")) { //이미 리그에 같은 팀이 등록되어있음
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
			else if(command.equals("league_team_step3")){  		//리그 팀 접수 스텝3
				response.setContentType("text/html;charset=UTF-8");
				inter = League_team_step3_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if (command.equals("leaderCheck")) { // 리그에 팀참가신청할때 팀장인지 확인
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = LeaderCheck_Service.instance();
				String count = inter.showData(request, response);
				if (count.equals("10")) {
					out.println("leader");
				}
			}
			
			else if (command.equals("matchapply")) { // 매치게시판 불러오기
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Matchapply_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			else if (command.equals("yonglist")) { // 용병게시판 불러오기
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
			else if (command.equals("match_apply_reg")) { // 매치신청 불러오기
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = match_apply_reg_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			else if (command.equals("groundsearchWhbranch")) { // 매치신청에서 선택한 지점의 구장정보 가져오는 ajax
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
			else if (command.equals("yongsign")) { // 용병등록 불러오기
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Yongsign_Service.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}
			//=======================리그메인, 리그접수,리그선수등록 컨트롤러 끝============================================================
			//=======================팀관리페이지컨트롤러====================================================================
			else if(command.equals("teamlist")){  //팀리스트  출력
				System.out.println("teamlist 출력");
				inter = TeamListView_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teaminfo")){  //팀정보 출력
				System.out.println("teaminfo 출력");
				inter = TeamInfoService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_regist")){  //팀등록 
				response.setContentType("text/html;charset=UTF-8");
				inter = TeamRegistService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("team_modify")){  //팀관리  출력
				System.out.println("team modify 출력");
				inter = TeamModifyService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamsearch")){  //팀리스트 검색  출력
				System.out.println("team search 출력");
				inter = TeamSearchService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamranking")){  //팀랭킹  출력
				System.out.println("team ranking 출력");
				inter = TeamRanking_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamplayer")){  //팀선수명단  출력
				System.out.println("team player 출력");
				inter = TeamPlayer_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teamapplyer")){  //팀가입신청명단  출력
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				System.out.println("team applyer List 출력");
				inter = TeamApplyList_Service.instance();
				String leaderresult = inter.showData(request, response);		
				System.out.println("컨트롤러에가져온 true는 있을까 : "+leaderresult);
				if (leaderresult.equals("true")) {
					out.println(
							"[ {" 
							+ "\"leaderteamresult\": \'" + "true" + "\'"
							+ "}" + "]");
				}
			}
			else if(command.equals("teamjoin")){  //가입신청 승인 거절
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				System.out.println("team join 승인 거절 출력");
				inter = Team_Join_Service.instance();
				inter.showData(request, response);						
			}
			else if (command.equals("teamcheck")) { 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = Team_apply_check_Service.instance();
				String leagueteamresult = inter.showData(request, response);
				System.out.println("컨트롤러에가져온 true는 있을까 : "+leagueteamresult);
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
			else if(command.equals("teamapply")){  //팀가입신청명단  출력
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("team apply 출력");
				PrintWriter out=response.getWriter();
				inter = TeamApply_Service.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("teammodifyform")){  //팀관리  출력
				System.out.println("team modify form 출력");
				inter = TeamModifyFormService.instance();
				viewName = inter.showData(request, response);		
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//===================팀관리페이지 컨트롤러 끝=======================================================
			//==================관리자페이지 컨트롤러==========================================================
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
			else if (command.equals("branch")) { //지점등록

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				inter = BrabchinsertService.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			//================관리자페이지 컨트롤러 끝===========================================================
			else {
				viewName = "error.jsp";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
	}
}
