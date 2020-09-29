package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SignModel;
import vo.QnaDto;


public class QnaSearch implements Cominterface{
	
	static QnaSearch impl = new QnaSearch();
	public static QnaSearch instance() { //instance �޼ҵ尡 �� ��ü�� �����ϴ� �� �̰��� �̱��� ���� !  static �� �پ������Ƿ� �ѹ� ����� ������ ����ؼ� �� �� �����Ƿ� �ߺ��� �ȵ����� 
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String searchsetting = request.getParameter("searchsetting");
		System.out.println("�˻����� : "+searchsetting);
		QnaDto board = new QnaDto();
		
		String qTitle = request.getParameter("searchword");	
		
		board.setQ_b_title(qTitle);
		System.out.println("�˻����� :"+board.getQ_b_title());
		if(searchsetting.equals("0")) {				//searchsetting �� ���� �˻��� ��� 0, ���� �˻��� ��� 1
			board.setQ_b_email("qTitle");				//board.setqEmail �� ���� ���� �˻����� ���뿡 ���� �˻����� ..
			System.out.println("board ���� ��:"+board.getQ_b_email());
		}
		else {
			board.setQ_b_email("qContents");
		}
		SignModel model = SignModel.instance();
		ArrayList<QnaDto> list = (ArrayList<QnaDto>)model.selectQnaSearch(board);
		if(list.size()==0) {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('�ش��ϴ� ������ �����ϴ�.');</script>");
			System.out.println("�ش��ϴ� ������ �����ϴ�.");
		}
		else {
		request.setAttribute("qnadata", list);
		System.out.println(list.get(0).getQ_b_title()+list.get(0).getQ_b_contents()+list.get(0).getQ_b_no());
		System.out.println("bb"+list.size());
		}
		return "qna.jsp";
	}
}

