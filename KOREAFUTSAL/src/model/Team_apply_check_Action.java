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
		System.out.println("Action player applycheck����");
		List<PlayerRegistDto> playerapplycheck = null;
		SqlSession sqlSession = factory.openSession();
		System.out.println("�տ����� ���̵� "+player.getId());
		System.out.println("�տ����� ���ڵ� "+player.getT_code());
		playerapplycheck = sqlSession.selectList("playerapplycheck",player);
	
		if(!playerapplycheck.isEmpty())
			System.out.println("���� �� ����� ������ ..�����¾��̵�: "+playerapplycheck.get(0).getId());
		else
			System.out.println("null �� ����..");
		sqlSession.close();
		return playerapplycheck;
	}
	public List<PlayerRegistDto> playerteamcheck(PlayerRegistDto player) {
		System.out.println("Action player teamcheck ����");
		List<PlayerRegistDto> playerteamcheck = null;
		SqlSession sqlSession = factory.openSession();
		
		System.out.println("�տ����� ���̵� "+player.getId());
		playerteamcheck = sqlSession.selectList("playerteamcheck",player);
		if(!playerteamcheck.isEmpty())
			System.out.println("�����¾��̵�: "+playerteamcheck.get(0).getId());
		sqlSession.close();
		return playerteamcheck;
	}
	
	

}