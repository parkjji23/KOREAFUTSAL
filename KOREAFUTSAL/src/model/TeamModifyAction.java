package model;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class TeamModifyAction {
	static TeamModifyAction model = new TeamModifyAction();

	public static TeamModifyAction instance() { // instance�޼ҵ尡 ��ü�� �׻� ��. �̱�������, static(����) �ѹ������ϸ� ��ü�������Ű�°�ó�� ������
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void modifyinform(TeamDto TeamDto) {
		System.out.println("TeamModifyAction ����");
		
		SqlSession sqlSession = factory.openSession();
			int result = sqlSession.update("Teammodify", TeamDto);	
			System.out.println("result : "+result);
			sqlSession.commit();
			sqlSession.close();
		
	}

}
