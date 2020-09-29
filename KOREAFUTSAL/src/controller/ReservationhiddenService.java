package controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.ComResInfoDto;
import model.GroundDto;
import model.ReservationList_Action;
import model.Reservationhidden_Action;
import model.SelectgroundAction;

public class ReservationhiddenService implements Cominterface {
	static ReservationhiddenService impl = new ReservationhiddenService();

	public static ReservationhiddenService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		
		int branch_no = Integer.parseInt(request.getParameter("branch_no"));
		String ground_name = request.getParameter("ground_name");
		ground_name = new String(ground_name.getBytes("8859_1"), "utf-8");
		String res_date = request.getParameter("res_date");
		Date res_date1 = Date.valueOf(res_date);
		ComResInfoDto comresinfodto = new ComResInfoDto();
		comresinfodto.setGround_name(ground_name);
		comresinfodto.setRes_date(res_date1);
		comresinfodto.setBranch_no(branch_no);
		
		Reservationhidden_Action model = Reservationhidden_Action.instance();
		ArrayList<ComResInfoDto> ComResInfoList = (ArrayList<ComResInfoDto>) model.selecthiddenobject(comresinfodto);
		request.setAttribute("data", ComResInfoList);
		String count_hidden= "";

		if (ComResInfoList.isEmpty()) {
			System.out.println("ReservationHidden이 비었습니다");
			count_hidden = "1011";

		} else {
			System.out.println("데이터가 잘 들어왔어요");
			count_hidden = "789";
		}

		return count_hidden;
	}

}
