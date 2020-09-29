package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Mypage_myteam_Action {
	static Mypage_myteam_Action model = new Mypage_myteam_Action();
	public static Mypage_myteam_Action instance(){
		return model;
	}

		private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


		public List<TeamDto> getmyteaminfo(String id){
			List<TeamDto> myteamlist = null;
			SqlSession sqlSession = factory.openSession();			
			myteamlist = sqlSession.selectList("myteam",id);
			
			sqlSession.close();
			return myteamlist;
		}
		
		public List<LeagueandLeagueResultDto> getmyleagueinfo(String id){
			List<LeagueandLeagueResultDto> myleaguelist = null;
			SqlSession sqlSession = factory.openSession();			
			myleaguelist = sqlSession.selectList("myleague",id);
			
			sqlSession.close();
			return myleaguelist;
		}
		
}
