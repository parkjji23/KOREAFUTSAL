package controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReservationDto;
import model.Reservation_Action;

public class Reservation_Service implements Cominterface{
	
	static Reservation_Service impl = new Reservation_Service();

	public static Reservation_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		int branch_no = Integer.parseInt(request.getParameter("branch_no"));
		int ground_no = Integer.parseInt(request.getParameter("ground_no"));
		int res_status = Integer.parseInt("10"); /*예약완료:20*/
		int payment_charge = Integer.parseInt(request.getParameter("payment_charge"));
		String id = request.getParameter("id");

		String datedate = request.getParameter("res_date");
		Date res_date = Date.valueOf(datedate);
		
		String res_time = request.getParameter("res_time");
		String branch_name = request.getParameter("branch_name");
		branch_name = new String(branch_name.getBytes("8859_1"), "utf-8");
		String ground_name = request.getParameter("ground_name_id");
		ground_name = new String(ground_name.getBytes("8859_1"), "utf-8");

		ReservationDto ReservationDto = new ReservationDto();
		ReservationDto.setRes_date(res_date);
		ReservationDto.setRes_time(res_time);
		ReservationDto.setRes_status(res_status);
		ReservationDto.setPayment_charge(payment_charge);
		ReservationDto.setId(id);
		ReservationDto.setGround_no(ground_no);
		
		HttpSession session = request.getSession();
		session.setAttribute("branch_no", branch_no);
		session.setAttribute("branch_name", branch_name);
		session.setAttribute("ground_name", ground_name);
		
		Reservation_Action model = Reservation_Action.instance();
		model.insertReservation(ReservationDto);
		return "paymentcompleted.jsp";
	}

}
