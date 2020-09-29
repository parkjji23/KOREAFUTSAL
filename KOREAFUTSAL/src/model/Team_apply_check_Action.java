package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Team_apply_check_Action {

	static Team_apply_check_Action model = new Team_apply_check_Action();

	public static Team_apply_check_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<PlayerRegistDto> playerapplycheck(PlayerRegistDto player) {
		System.out.println("Action player applycheck접근");
		List<PlayerRegistDto> playerapplycheck = null;
		SqlSession sqlSession = factory.openSession();
		System.out.println("앞에서온 아이디 "+player.getId());
		System.out.println("앞에서온 팀코드 "+player.getT_code());
		playerapplycheck = sqlSession.selectList("playerapplycheck",player);
	
		if(!playerapplycheck.isEmpty())
			System.out.println("지원 한 결과가 있으며 ..가져온아이디: "+playerapplycheck.get(0).getId());
		else
			System.out.println("null 이 담겼다..");
		sqlSession.close();
		return playerapplycheck;
	}
	public List<PlayerRegistDto> playerteamcheck(PlayerRegistDto player) {
		System.out.println("Action player teamcheck 접근");
		List<PlayerRegistDto> playerteamcheck = null;
		SqlSession sqlSession = factory.openSession();
		
		System.out.println("앞에서온 아이디 "+player.getId());
		playerteamcheck = sqlSession.selectList("playerteamcheck",player);
		if(!playerteamcheck.isEmpty())
			System.out.println("가져온아이디: "+playerteamcheck.get(0).getId());
		sqlSession.close();
		return playerteamcheck;
	}
	
	

}