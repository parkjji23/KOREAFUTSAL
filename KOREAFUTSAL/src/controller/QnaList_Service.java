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
	public static QnaList_Service instance() { //instance �޼ҵ尡 �� ��ü�� �����ϴ� �� �̰��� �̱��� ���� !  static �� �پ������Ƿ� �ѹ� ����� ������ ����ؼ� �� �� �����Ƿ� �ߺ��� �ȵ����� 
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
		//���� �� �������� �Ѿ���� ���ڵ��̴�. �ش� ���� �۸� select�ϱ����� �����´�.
		
		
		String searchType = request.getParameter("searchtype");
		String search = request.getParameter("search");
		if(search!=null)
			search= new String(search.getBytes("8859_1"), "utf-8");
		Qna_Action qna_action = Qna_Action.instance();
		TeamPageDto teamPageDto = new TeamPageDto();
		teamPageDto.setPage(startrow);
		teamPageDto.setKeyword(search);
		teamPageDto.setSearchType(searchType);
		System.out.println("Ÿ����?"+searchType);
		System.out.println("---------�����������������Դϴ�---------");
		System.out.println(teamPageDto.getPage());
		System.out.println(teamPageDto.getKeyword());
		System.out.println(teamPageDto.getSearchType());
		System.out.println("--------------------------------");
		
		
		qnalist = (ArrayList<QnaDto>) qna_action.selectQnaList(teamPageDto);
		System.out.println(qnalist.size());
		listCount = qna_action.getListCount(teamPageDto);
		System.out.println(listCount+"����Ʈī��Ʈ");
		//�� ������ ��.
   		int maxPage=(int)((double)listCount/limit+1); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		System.out.println(maxPage+"�ƽ�������");
   		
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;
   		
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		System.out.println(endPage+"����������");
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("qnaList", qnalist);
		return "qna.jsp";
	}
}

