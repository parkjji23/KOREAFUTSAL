package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Res_statusAction {
	static Res_statusAction model = new Res_statusAction();

	public static Res_statusAction instance() {
		return model;
	}
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void updateresstaus(ReservationDto ReservationDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("res_status_update",ReservationDto);
		sqlSession.commit();
		sqlSession.close();
	}

}
