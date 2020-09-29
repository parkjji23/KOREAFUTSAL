
package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.AdminBrabchRepinsertAction;
import model.AdminBranchRepDto;
import model.BranchDetail_Action;
import model.BranchDto;
import model.GroundDto;
import model.GroundinsertAction;

public class GroundinsertService implements Cominterface {

	static GroundinsertService impl = new GroundinsertService();

	public static GroundinsertService instance() {
		System.out.println("È®ï¿½ï¿½2");
		return impl;

		
		
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("È®ï¿½ï¿½3");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String realFolder="";
		String saveFolder="/groundUploadd";
		int fileSize=5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);  
		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		
		
	
		
		
		
	
		String ground_name =multi.getParameter("ground_name");
		System.out.println(ground_name);
		
		String ground_size_1 = multi.getParameter("ground_size_1");
		String ground_size_2 = multi.getParameter("ground_size_2");
		System.out.println(ground_size_1);
		System.out.println(ground_size_2);

		String ground_field = multi.getParameter("ground_field");
		System.out.println(ground_field);

		
		int ground_weekdaydaytime_charge = Integer.parseInt( multi.getParameter("ground_weekdaydaytime_charge"));
		int ground_weekdaynight_charge =Integer.parseInt( multi.getParameter("ground_weekdaynight_charge"));
		int ground_weekenddaytime_charge =Integer.parseInt(multi.getParameter("ground_weekenddaytime_charge")) ;
		int ground_weekendnight_charge =Integer.parseInt(multi.getParameter("ground_weekendnight_charge")) ;
		System.out.println(ground_weekdaydaytime_charge);
		System.out.println(ground_weekdaynight_charge);
		System.out.println(ground_weekenddaytime_charge);
		System.out.println(ground_weekendnight_charge);
		
		
		String ground_rule = multi.getParameter("ground_rule");
		System.out.println(ground_rule);
		
		String branch_no = multi.getParameter("branch_no");
		int branch_no1 =Integer.parseInt(multi.getParameter("branch_no"));
		System.out.println(branch_no);
		
		String ground_pic =multi.getParameter("abc");
		System.out.println(ground_pic);
		
		
	

		

				

		GroundDto GroundDto = new GroundDto();
		
		GroundDto.setGround_name(ground_name);
		System.out.println("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½"+GroundDto.getGround_name());
		
		GroundDto.setGround_size(ground_size_1+"m" + "X"+ground_size_2+"m");
		
		GroundDto.setGround_field(ground_field);
		
		GroundDto.setGround_weekdaydaytime_charge(ground_weekdaydaytime_charge);
		GroundDto.setGround_weekdaynight_charge(ground_weekdaynight_charge);
		GroundDto.setGround_weekenddaytime_charge(ground_weekenddaytime_charge);
		GroundDto.setGround_weekendnight_charge(ground_weekendnight_charge);
		
		GroundDto.setGround_rule(ground_rule);
		
		GroundDto.setBranch_no(branch_no1);
		
		GroundDto.setGround_pic(ground_pic);
		

		GroundinsertAction model = GroundinsertAction.instance();
		model.insertinform(GroundDto);
	
		////////////////////
		
		BranchDetail_Action branchdetailmodel = BranchDetail_Action.instance();
	    ArrayList<BranchDto> BranchList = (ArrayList<BranchDto>) branchdetailmodel.getBranchDetail(branch_no);
	   	request.setAttribute("BranchList", BranchList);
	   	System.out.println("È®ÀÎÁß3");
	   	
	   	AdminBrabchRepinsertAction BrabchRepmodel = AdminBrabchRepinsertAction.instance();
	    ArrayList<AdminBranchRepDto> AdminBranchRepList = (ArrayList<AdminBranchRepDto>) BrabchRepmodel.getAdminBranchRep(branch_no);
	   	
	    request.setAttribute("AdminBranchRepList", AdminBranchRepList);
	   	
	   	
	   	
	   	
	   	
	   	
		System.out.println(request.getAttribute("BranchList")); 
		return "admin_branch_view.jsp";
		
		
	}

}
