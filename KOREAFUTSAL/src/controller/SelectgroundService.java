package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConfirmIdAction;
import model.GroundDto;
import model.SelectgroundAction;

public class SelectgroundService implements Cominterface{
	
	static SelectgroundService impl = new SelectgroundService();

	public static SelectgroundService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String ground_name = request.getParameter("ground_name");
		 ground_name = new String(ground_name.getBytes("8859_1"), "utf-8");
		 int branch_no = Integer.parseInt(request.getParameter("branch_no"));
		 GroundDto groundDto = new GroundDto();
		 groundDto.setGround_name(ground_name);
		 groundDto.setBranch_no(branch_no);
		 String dayOfweek = request.getParameter("dayOfweek");
		 ground_name = new String(ground_name.getBytes("8859_1"), "utf-8");
			SelectgroundAction model = SelectgroundAction.instance();
			ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) model.selectGroundname(groundDto);
			request.setAttribute("data", GroundList);
			String count="";
			
			if(GroundList.isEmpty()) {
				count="456";

			} else {
				count="123";
			}

			return count;
		}
}
