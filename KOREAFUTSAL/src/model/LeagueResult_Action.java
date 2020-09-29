package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class LeagueResult_Action {
	
	static LeagueResult_Action model = new LeagueResult_Action();
	public static LeagueResult_Action instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


	public List<LeagueResultDto> getLeagueResult(LeagueResultDto leagueresult){
		List<LeagueResultDto> LeagueResult = null;
		System.out.println("LeagueResult_Ation 에서 leagueresult 잘 넘어왔는지 leagueresult의 팀 코드"+leagueresult.getT_code());
		LeagueResultDto obb = leagueresult;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		SqlSession sqlSession = factory.openSession();			
		LeagueResult = sqlSession.selectList("league_result",obb);
		sqlSession.close();
		return LeagueResult;
	}
	public List<LeagueResultDto> getLeaguePoint(LeagueResultDto leagueresult){
		List<LeagueResultDto> LeagueResult = null;
		LeagueResultDto obb = leagueresult;
		SqlSession sqlSession = factory.openSession();			
		LeagueResult = sqlSession.selectList("league_point",obb);
		sqlSession.close();
		return LeagueResult;
	}
	public List<LeagueDto> getLeague(LeagueResultDto leagueresult){
		List<LeagueDto> LeagueResult = null;
		System.out.println("LeagueResult_Ation 에서 leagueresult 잘 넘어왔는지 leagueresult의 팀 코드"+leagueresult.getT_code());
		LeagueResultDto obb = leagueresult;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		SqlSession sqlSession = factory.openSession();			
		LeagueResult = sqlSession.selectList("league",obb);
		System.out.println("문제없이 잘 받아온다.");
		sqlSession.close();
		return LeagueResult;
	}
	


}
