package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.MatchlistDto;

public class Matchapply_Action {
	static Matchapply_Action model = new Matchapply_Action();

	public static Matchapply_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int getListCount(TeamPageDto teamPageDto) {
		int listCount = 0;
		SqlSession sqlSession = factory.openSession();
		listCount=sqlSession.selectOne("matchtotalcount",teamPageDto);
		sqlSession.close();
		return listCount;
	}

	public List<MatchlistDto> getMacthList(TeamPageDto teamPageDto) {
		
		List<MatchlistDto> matchlist = null;
		SqlSession sqlSession = factory.openSession();
		matchlist = sqlSession.selectList("getmatchlist",teamPageDto);
		sqlSession.close();
		return matchlist;
	}

	
	
}
