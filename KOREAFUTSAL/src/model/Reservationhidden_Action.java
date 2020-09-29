package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Reservationhidden_Action {
	static Reservationhidden_Action model = new Reservationhidden_Action();
	public static Reservationhidden_Action instance(){ 
		return model;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); 

	public List<ComResInfoDto> selecthiddenobject(ComResInfoDto ComResInfoDto){
		List<ComResInfoDto> ComResInfoList=null;
		SqlSession sqlSession = factory.openSession();
		ComResInfoList = sqlSession.selectList("rescomplete_ground_as_date",ComResInfoDto);
		sqlSession.close();
		return ComResInfoList;
	}
}
