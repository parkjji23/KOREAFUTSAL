package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Onedaystatus30_Action {
	static Onedaystatus30_Action model = new Onedaystatus30_Action();

	public static Onedaystatus30_Action instance() {
		return model;
	}
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void onedaylater_update(ReservationDto ReservationDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("oneday_status30",ReservationDto);
		sqlSession.commit();
		sqlSession.close();
	}

}
