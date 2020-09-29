package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class LeagueResult_Action2 {
	
	static LeagueResult_Action2 model = new LeagueResult_Action2();
	public static LeagueResult_Action2 instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


	public List<LeagueResultDto> getLeagueResult(int league_code){	//"리그코드"로 검색한 그 리그들을 뽑아온다.
		List<LeagueResultDto> LeagueResult = null;
		SqlSession sqlSession = factory.openSession();			
		LeagueResult = sqlSession.selectList("league_result_Whleague",league_code);
		sqlSession.close();
		return LeagueResult;
	}
	public List<PlayerRegistDto> getLeaguePlayer(int league_code){
		List<PlayerRegistDto> LeaguePlayer = null;
		SqlSession sqlSession = factory.openSession();			
		LeaguePlayer = sqlSession.selectList("league_player_Whleague",league_code);
		sqlSession.close();
		return LeaguePlayer;
	}
}
