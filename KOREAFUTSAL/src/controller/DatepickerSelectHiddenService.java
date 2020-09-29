package controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComResInfoDto;
import model.DatepickerSelectHiddenAction;
import model.DeleteReservation_Action;
import model.ReservationDto;
import model.Reservationhidden_Action;

public class DatepickerSelectHiddenService implements Cominterface{
	static DatepickerSelectHiddenService impl = new DatepickerSelectHiddenService();

	public static DatepickerSelectHiddenService instance() {
		return impl;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		int branch_no = Integer.parseInt(request.getParameter("branch_no"));
		String res_date = request.getParameter("res_date");
		Date res_date1 = Date.valueOf(res_date);
		ComResInfoDto comresinfodto = new ComResInfoDto();
		comresinfodto.setRes_date(res_date1);
		comresinfodto.setBranch_no(branch_no);
		
		DatepickerSelectHiddenAction model = DatepickerSelectHiddenAction.instance();
		ArrayList<ComResInfoDto> ComResInfoList = (ArrayList<ComResInfoDto>) model.datepickerselecthidden(comresinfodto);
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
