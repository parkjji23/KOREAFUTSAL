package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class DeleteReservation_Action {
	static DeleteReservation_Action model = new DeleteReservation_Action();

	public static DeleteReservation_Action instance() { // instance메소드가 객체를 항상 뱉어냄. 싱글톤패턴, static(정적) 한번실행하면 전체를실행시키는것처럼 느껴짐
		return model;
	}
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void Reservationdelete(int res_no) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("reservation_delete", res_no);
		sqlSession.commit();
		sqlSession.close();
	}
	
}