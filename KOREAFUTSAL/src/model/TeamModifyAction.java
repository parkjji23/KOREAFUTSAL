package model;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class TeamModifyAction {
	static TeamModifyAction model = new TeamModifyAction();

	public static TeamModifyAction instance() { // instance메소드가 객체를 항상 뱉어냄. 싱글톤패턴, static(정적) 한번실행하면 전체를실행시키는것처럼 느껴짐
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void modifyinform(TeamDto TeamDto) {
		System.out.println("TeamModifyAction 접근");
		
		SqlSession sqlSession = factory.openSession();
			int result = sqlSession.update("Teammodify", TeamDto);	
			System.out.println("result : "+result);
			sqlSession.commit();
			sqlSession.close();
		
	}

}
