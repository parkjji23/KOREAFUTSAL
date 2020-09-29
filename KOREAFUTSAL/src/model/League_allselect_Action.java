package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class League_allselect_Action {

	static League_allselect_Action model = new League_allselect_Action();

	public static League_allselect_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<LeagueDto> getLeagueall() {

		List<LeagueDto> leagueAllList = null;
		SqlSession sqlSession = factory.openSession();
		leagueAllList = sqlSession.selectList("leagueallselect");
		sqlSession.close();
		return leagueAllList;
	}

}