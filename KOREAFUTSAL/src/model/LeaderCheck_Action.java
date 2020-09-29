package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class LeaderCheck_Action {
	
	static LeaderCheck_Action model = new LeaderCheck_Action();
	public static LeaderCheck_Action instance(){ 
		return model;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); 

	public List<TeamDto> leadercheck(String id){ 
		List<TeamDto> leadercheckteam=null;
		SqlSession sqlSession = factory.openSession();
		leadercheckteam = sqlSession.selectList("leadercheck",id);
		sqlSession.close();
		return leadercheckteam;
	}


}
