package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Paymentpage_Action {
	static Paymentpage_Action model = new Paymentpage_Action();

	public static Paymentpage_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void insertReservation_paymentpage(ReservationDto ReservationDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("input_reservation_paymentpage", ReservationDto);
		sqlSession.commit();
		sqlSession.close();
	}
}
