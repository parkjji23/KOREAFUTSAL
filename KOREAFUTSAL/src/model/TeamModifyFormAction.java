package model;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class TeamModifyFormAction {
	static TeamModifyFormAction model = new TeamModifyFormAction();

	public static TeamModifyFormAction instance() { // instance�޼ҵ尡 ��ü�� �׻� ��. �̱�������, static(����) �ѹ������ϸ� ��ü�������Ű�°�ó�� ������
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<TeamDto> getTeamList(TeamDto TeamDto) {
		System.out.println("getTeamListAction ����");
		List<TeamDto> list = null;
		SqlSession sqlSession = factory.openSession();
		list= sqlSession.selectList("teamone", TeamDto);	
		sqlSession.close();
		return list;
	}
}
