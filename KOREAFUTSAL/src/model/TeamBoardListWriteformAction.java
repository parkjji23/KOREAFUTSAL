package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class TeamBoardListWriteformAction {
	static TeamBoardListWriteformAction model = new TeamBoardListWriteformAction();

	public static TeamBoardListWriteformAction instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<TeamDto> getTeamList(String id) {
		List<TeamDto> teamlist = null;
		SqlSession sqlSession = factory.openSession();
		teamlist = sqlSession.selectList("teamlist", id);
		sqlSession.close();
		return teamlist;
	}
}
