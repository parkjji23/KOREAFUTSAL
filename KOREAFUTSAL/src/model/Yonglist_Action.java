package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.MatchlistDto;
import vo.YonglistDto;

public class Yonglist_Action {
	static Yonglist_Action model = new Yonglist_Action();

	public static Yonglist_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int getListCount(TeamPageDto teamPageDto) {
		int listCount = 0;
		SqlSession sqlSession = factory.openSession();
		listCount=sqlSession.selectOne("yongtotalcount",teamPageDto);
		sqlSession.close();
		return listCount;
	}

	public List<YonglistDto> getYongList(TeamPageDto teamPageDto) {
		
		List<YonglistDto> yonglist = null;
		SqlSession sqlSession = factory.openSession();
		yonglist = sqlSession.selectList("getyonglist",teamPageDto);
		sqlSession.close();
		return yonglist;
	}

	
	
}
