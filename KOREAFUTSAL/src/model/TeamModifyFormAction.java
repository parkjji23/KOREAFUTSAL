package model;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class TeamModifyFormAction {
	static TeamModifyFormAction model = new TeamModifyFormAction();

	public static TeamModifyFormAction instance() { // instance메소드가 객체를 항상 뱉어냄. 싱글톤패턴, static(정적) 한번실행하면 전체를실행시키는것처럼 느껴짐
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<TeamDto> getTeamList(TeamDto TeamDto) {
		System.out.println("getTeamListAction 접근");
		List<TeamDto> list = null;
		SqlSession sqlSession = factory.openSession();
		list= sqlSession.selectList("teamone", TeamDto);	
		sqlSession.close();
		return list;
	}
}
