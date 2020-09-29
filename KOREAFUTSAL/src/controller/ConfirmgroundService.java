package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ConfirmgroundAction;
import model.GroundDto;


public class ConfirmgroundService implements Cominterface {

	static ConfirmgroundService impl = new ConfirmgroundService();

	public static ConfirmgroundService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String ground_name = request.getParameter("ground_name");
		 System.out.println("구장명은?"+ground_name);
		 ConfirmgroundAction model = ConfirmgroundAction.instance();
		ArrayList<GroundDto> checkuser = (ArrayList<GroundDto>) model.selectground(ground_name);
		request.setAttribute("data", checkuser);
		String count="";
		
		if(checkuser.isEmpty()) {
			
			count="456";

		} else {
			
			count="123";
		}
         
		return count;
	}

}
