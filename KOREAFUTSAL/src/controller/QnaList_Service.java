package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Qna_Action;
import model.TeamPageDto;
import vo.PageInfo;
import vo.QnaDto;


public class QnaList_Service implements Cominterface{
	
	static QnaList_Service impl = new QnaList_Service();
	public static QnaList_Service instance() { //instance 메소드가 늘 객체를 리턴하는 것 이것이 싱글톤 패턴 !  static 이 붙어있으므로 한번 만들어 놓으면 계속해서 쓸 수 있으므로 중복이 안되지만 
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int page=1;
		int limit=10;
		int listCount=1;
		
		ArrayList<QnaDto> qnalist = new ArrayList<QnaDto>();
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		int startrow = (page - 1) * 9;
		//우측 팀 눌렀을때 넘어오는 팀코드이다. 해당 팀의 글만 select하기위해 가져온다.
		
		
		String searchType = request.getParameter("searchtype");
		String search = request.getParameter("search");
		if(search!=null)
			search= new String(search.getBytes("8859_1"), "utf-8");
		Qna_Action qna_action = Qna_Action.instance();
		TeamPageDto teamPageDto = new TeamPageDto();
		teamPageDto.setPage(startrow);
		teamPageDto.setKeyword(search);
		teamPageDto.setSearchType(searchType);
		System.out.println("타입은?"+searchType);
		System.out.println("---------가져온페이지정보입니다---------");
		System.out.println(teamPageDto.getPage());
		System.out.println(teamPageDto.getKeyword());
		System.out.println(teamPageDto.getSearchType());
		System.out.println("--------------------------------");
		
		
		qnalist = (ArrayList<QnaDto>) qna_action.selectQnaList(teamPageDto);
		System.out.println(qnalist.size());
		listCount = qna_action.getListCount(teamPageDto);
		System.out.println(listCount+"리스트카운트");
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+1); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		System.out.println(maxPage+"맥스페이지");
   		
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;
   		
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		System.out.println(endPage+"엔드페이지");
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("qnaList", qnalist);
		return "qna.jsp";
	}
}

