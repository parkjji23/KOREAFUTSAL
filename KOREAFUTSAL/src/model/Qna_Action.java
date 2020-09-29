package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.QnaDto;

public class Qna_Action {
	
	static Qna_Action model = new Qna_Action();
	public static Qna_Action instance(){ //instance �޼ҵ尡 �� ��ü�� �����ϴ� �� �̰��� �̱��� ���� !
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();           // Map �� �ִ� sqlSession factory ���ڴ� �Ʊ� Map.java(SqlMapConfig �� ã�ư��� ����.)

	public List<QnaDto> selectQnaList(TeamPageDto teamPageDto){
		List<QnaDto> list = null;	
		SqlSession sqlSession = factory.openSession();
		System.out.println("selectQnaList�� ��������"+teamPageDto.getPage());
		list = sqlSession.selectList("getqnalist",teamPageDto);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 		
		sqlSession.close();
		return list;
	}
	public int getListCount(TeamPageDto teamPageDto) {
		int listCount = 0;
		SqlSession sqlSession = factory.openSession();
		listCount=sqlSession.selectOne("qnatotalcount",teamPageDto);
		sqlSession.close();
		return listCount;
	}
	
	
	
}
