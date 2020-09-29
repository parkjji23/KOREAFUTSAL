package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.TeamDto;
import model.TeamRegistAction;
import vo.ActionForward;
import vo.GalBoardDto;



public class TeamRegistService implements Cominterface {

	static TeamRegistService impl = new TeamRegistService();

	public static TeamRegistService instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Random random = new Random();
		
		response.setContentType("text/html;charset=UTF-8");
		//////////////////////////////////
		
		request.setCharacterEncoding("UTF-8");
		
		String realFolder="";
		String saveFolder="/img";
		int fileSize=5*1024*1024;
		TeamDto TeamDto = new TeamDto();
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);  
		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		//////////////////////////////////
		
		
		
		TeamDto.setId(multi.getParameter("id"));
		TeamDto.setT_name(multi.getParameter("t_name"));
		TeamDto.setT_class(multi.getParameter("t_type"));
		TeamDto.setT_uniform_home(multi.getParameter("t_h_uniform_t")+"-"+multi.getParameter("t_h_uniform_b")+"-"+multi.getParameter("t_h_uniform_s"));
		TeamDto.setT_uniform_away(multi.getParameter("t_a_uniform_t")+"-"+multi.getParameter("t_a_uniform_b")+"-"+multi.getParameter("t_a_uniform_s"));
		TeamDto.setT_email(multi.getParameter("t_email"));
		TeamDto.setT_logo(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		TeamRegistAction model = TeamRegistAction.instance();
		System.out.println("TeamRegistService 접근3");
		model.insertinform(TeamDto);
		System.out.println("TeamRegistService 접근4");
		
		
		request.setAttribute("id", multi.getParameter("id"));
		request.setAttribute("t_name", multi.getParameter("t_name"));
		request.setAttribute("t_email", multi.getParameter("t_email"));
		
		
		
		
		
		
		
		return "registResult.jsp";
	}

}
