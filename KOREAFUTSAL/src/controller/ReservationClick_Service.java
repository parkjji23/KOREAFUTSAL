package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.ComResInfoDto;
import model.GroundDto;
import model.Onedaystatus30_Action;
import model.ReservationClick_Action;
import model.ReservationDto;

public class ReservationClick_Service implements Cominterface{
	
	static ReservationClick_Service impl = new ReservationClick_Service();

	public static ReservationClick_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String branch_no = request.getParameter("branch_no");
		ReservationClick_Action reservationclick_model = ReservationClick_Action.instance();
		ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) reservationclick_model.reservation_ground(branch_no);
		int fulldate = GroundList.size();
		ComResInfoDto comResInfoDto = new ComResInfoDto();
		comResInfoDto.setBranch_no(Integer.parseInt(branch_no));
		comResInfoDto.setFulldate(fulldate);
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) reservationclick_model.reservation_branch(branch_no);
		ArrayList<ReservationDto> ReservationList = (ArrayList<ReservationDto>) reservationclick_model.getbookedDate(branch_no);
		ArrayList<ComResInfoDto> fulldatelist = (ArrayList<ComResInfoDto>) reservationclick_model.getfulldate(comResInfoDto);
		
		//결제가 안되고 24시간 지난 예약은 취소시키기
		Onedaystatus30_Action model = Onedaystatus30_Action.instance();
		ReservationDto resoneday = new ReservationDto();
		model.onedaylater_update(resoneday);
		//
		
		request.setAttribute("GroundList", GroundList);
		request.setAttribute("BranchList", BranchList);
		request.setAttribute("ReservationList", ReservationList);
		request.setAttribute("fulldatelist", fulldatelist);
		return "reservation.jsp";

	}

}
