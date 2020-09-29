package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.BranchDto;
import model.BranchList_Action;
import model.TeamBoardListDto;
import mybatis.SqlMapConfig;

public class TeamBoardListAction {
	static TeamBoardListAction model = new TeamBoardListAction();

	public static TeamBoardListAction instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int getListCount(TeamPageDto teamPageDto) {
		int listCount = 0;
		SqlSession sqlSession = factory.openSession();
		listCount=sqlSession.selectOne("gettotalcount",teamPageDto);
		sqlSession.close();
		return listCount;
	}

	public List<TeamBoardListDto> getTeamBoardList(TeamPageDto teamPageDto) {
		
		List<TeamBoardListDto> teamboardlist = null;
		SqlSession sqlSession = factory.openSession();
		teamboardlist = sqlSession.selectList("listPage",teamPageDto);
		sqlSession.close();
		return teamboardlist;
	}
	public List<NoticeboardDto> getnoticelist(String a) {
		
		List<NoticeboardDto> noticelist = null;
		SqlSession sqlSession = factory.openSession();
		noticelist = sqlSession.selectList("noticeboardList3",a);
		sqlSession.close();
		return noticelist;
	}
	
	
}
