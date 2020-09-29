package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BranchDto;
import model.GroundDto;
import model.Onedaystatus30_Action;
import model.ReservationDto;
import model.ReservationList_Action;

public class ReservationList_Service implements Cominterface{
	static ReservationList_Service impl = new ReservationList_Service();

	public static ReservationList_Service instance() {
		return impl;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");

		ReservationList_Action reservationlistaction = ReservationList_Action.instance();
		ArrayList<ReservationDto> reservationlist = (ArrayList<ReservationDto>) reservationlistaction.getReservationList(id);
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) reservationlistaction.getReservationListBranch(id);
		ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) reservationlistaction.getReservationListGround(id);
		

		//결제가 안되고 24시간 지난 예약은 취소시키기
		Onedaystatus30_Action model = Onedaystatus30_Action.instance();
		ReservationDto resoneday = new ReservationDto();
		model.onedaylater_update(resoneday);
		//

		request.setAttribute("reservationlist", reservationlist);
		request.setAttribute("BranchList", BranchList);
		request.setAttribute("GroundList", GroundList);
		return "reservation_list.jsp";
	}
}
