package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BranchDto;
import model.GroundDto;
import model.Paymentpage_Action;
import model.PaymentsuccessAction;
import model.Res_statusAction;
import model.ReservationClick_Action;
import model.ReservationDto;
import model.ReservationList_Action;

public class PaymentsuccessService implements Cominterface{
	static PaymentsuccessService impl = new PaymentsuccessService();

	public static PaymentsuccessService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int res_no = Integer.parseInt(request.getParameter("res_no"));
		
		ReservationDto ReservationDto = new ReservationDto();
		ReservationDto.setRes_no(res_no);
		
		PaymentsuccessAction model = PaymentsuccessAction.instance();
		ArrayList<ReservationDto> ReservationList = (ArrayList<ReservationDto>) model.getsuccessReservation(res_no);
		ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) model.getsuccessBranch(res_no);
		ArrayList<GroundDto> GroundList = (ArrayList<GroundDto>) model.getsuccessGround(res_no);
		request.setAttribute("ReservationList", ReservationList);
		request.setAttribute("BranchList", BranchList);
		request.setAttribute("GroundList", GroundList);
		System.out.println("레스넘레스넘"+res_no);
		request.setAttribute("res_no", res_no);
		return "PaymentSuccess.jsp";
	}

}
