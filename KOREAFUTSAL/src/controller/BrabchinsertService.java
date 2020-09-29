package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BrabchinsertAction;
import model.BranchDto;

public class BrabchinsertService implements Cominterface {

	static BrabchinsertService impl = new BrabchinsertService();

	public static BrabchinsertService instance() {
		
		return impl;

		
		
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String realFolder="";
		String saveFolder="/branchUpload";
		int fileSize=5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);  
		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		
		
	
		
		
		
	
		String branch_name =multi.getParameter("branch_name");
		String tel1 = multi.getParameter("tel1");
		String tel2 = multi.getParameter("tel2");
		String tel3 = multi.getParameter("tel3");
		
		String parking = multi.getParameter("parking");
		String aircon = multi.getParameter("aircon");
		String shower = multi.getParameter("shower");
		String ball = multi.getParameter("ball");
		String vest = multi.getParameter("vest");
		String shoes = multi.getParameter("shoes");
		
		
		
		
		
		
		String address_code = multi.getParameter("address_code");
		String address_basic = multi.getParameter("address_basic");
		String address_detail = multi.getParameter("address_detail");
		String branch_pic =multi.getParameter("abc");
		
		
		String id =multi.getParameter("brabchId");
		String name =multi.getParameter("name");
		System.out.println("이름은?1"+name);
		
	

		

				

		BranchDto BranchDto = new BranchDto();
		BranchDto.setBranch_name(branch_name);
		BranchDto.setBranch_tel(tel1 + "-" + tel2 + "-" + tel3);
		BranchDto.setBranch_location(address_basic);
		BranchDto.setBranch_convenience(parking + ","+aircon + ","+shower + ","+ball + ","+vest + ","+shoes);
		BranchDto.setBranch_pic(branch_pic);
		BranchDto.setId(id);
		BranchDto.setName(name);
		System.out.println("이름은?2"+BranchDto.getName());
		

		BrabchinsertAction model = BrabchinsertAction.instance();
		model.insertinform(BranchDto);
		return "branch.jsp";
	}

}
