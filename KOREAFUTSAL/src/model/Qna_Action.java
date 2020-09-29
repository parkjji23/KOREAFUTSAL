package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.QnaDto;

public class Qna_Action {
	
	static Qna_Action model = new Qna_Action();
	public static Qna_Action instance(){ //instance 메소드가 늘 객체를 리턴하는 것 이것이 싱글톤 패턴 !
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();           // Map 에 있는 sqlSession factory 쓰겠다 아까 Map.java(SqlMapConfig 를 찾아가서 쓴다.)

	public List<QnaDto> selectQnaList(TeamPageDto teamPageDto){
		List<QnaDto> list = null;	
		SqlSession sqlSession = factory.openSession();
		System.out.println("selectQnaList의 팀페이지"+teamPageDto.getPage());
		list = sqlSession.selectList("getqnalist",teamPageDto);       // sqlSession 을 불러온 DB를 쓸건데 거기서 selectList 쓴다. mapper 파일에서 태그 이름 ! 		
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
