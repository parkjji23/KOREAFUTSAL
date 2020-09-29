package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.TeamDto;
import model.TeamModifyAction;




public class TeamModifyService implements Cominterface {

	static TeamModifyService impl = new TeamModifyService();

	public static TeamModifyService instance() {
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
		int t_code = Integer.parseInt(request.getParameter("t_code"));
		TeamDto.setId(multi.getParameter("id"));
		TeamDto.setT_code(t_code);
		TeamDto.setT_name(multi.getParameter("t_name"));
		TeamDto.setT_class(multi.getParameter("t_type"));
		TeamDto.setT_uniform_home("상의 - "+multi.getParameter("t_h_uniform_t")+" 하의 - "+multi.getParameter("t_h_uniform_b")+" 스타킹 - "+multi.getParameter("t_h_uniform_s"));
		TeamDto.setT_uniform_away("상의 - "+multi.getParameter("t_a_uniform_t")+" 하의 - "+multi.getParameter("t_a_uniform_b")+" 스타킹 - "+multi.getParameter("t_a_uniform_s"));
		TeamDto.setT_email(multi.getParameter("t_email"));
		TeamDto.setT_logo(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		System.out.println(TeamDto.getT_logo());
		TeamModifyAction model = TeamModifyAction.instance();
		
		model.modifyinform(TeamDto);
		System.out.println("수정완료");
		return "teamlist.do?command=teamlist";
	}

}
