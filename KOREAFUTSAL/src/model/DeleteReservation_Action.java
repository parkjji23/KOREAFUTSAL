package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class DeleteReservation_Action {
	static DeleteReservation_Action model = new DeleteReservation_Action();

	public static DeleteReservation_Action instance() { // instance�޼ҵ尡 ��ü�� �׻� ��. �̱�������, static(����) �ѹ������ϸ� ��ü�������Ű�°�ó�� ������
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