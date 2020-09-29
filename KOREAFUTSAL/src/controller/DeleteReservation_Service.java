package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteReservation_Action;
import model.ReservationDto;

public class DeleteReservation_Service implements Cominterface{
	static DeleteReservation_Service impl = new DeleteReservation_Service();

	public static DeleteReservation_Service instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		int res_no = Integer.parseInt(request.getParameter("res_no"));
		String id = request.getParameter("id");

		ReservationDto ReservationDto = new ReservationDto();
		ReservationDto.setRes_no(res_no);
		DeleteReservation_Action model = DeleteReservation_Action.instance();
		model.Reservationdelete(res_no);
		
		
		return "mypage.do?command=reservation_list&id="+id;
	}

}
