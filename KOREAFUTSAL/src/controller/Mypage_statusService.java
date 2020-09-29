package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Res_statusAction;
import model.ReservationDto;
import model.Reservation_Action;

public class Mypage_statusService implements Cominterface{
	static Mypage_statusService impl = new Mypage_statusService();

	public static Mypage_statusService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		int res_no = Integer.parseInt(request.getParameter("res_no"));
		int res_status = Integer.parseInt("20"); //*결제완료:20*/
		String id = request.getParameter("id");
		
		ReservationDto ReservationDto = new ReservationDto();
		ReservationDto.setRes_no(res_no);
		ReservationDto.setRes_status(res_status);
		
		Res_statusAction model = Res_statusAction.instance();
		model.updateresstaus(ReservationDto);
		return "mypage.do?command=reservation_list&id="+id;
	}

}
