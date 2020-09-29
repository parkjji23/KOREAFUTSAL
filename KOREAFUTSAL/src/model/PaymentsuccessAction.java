package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class PaymentsuccessAction {
	static PaymentsuccessAction model = new PaymentsuccessAction();

	public static PaymentsuccessAction instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<ReservationDto> getsuccessReservation(int res_no) {
		List<ReservationDto> ReservationList = null;
		SqlSession sqlSession = factory.openSession();
		ReservationList = sqlSession.selectList("paymentsuccess_Reservation", res_no);
		sqlSession.close();
		return ReservationList;
	}
	public List<BranchDto> getsuccessBranch(int res_no) {
		List<BranchDto> BranchList = null;
		SqlSession sqlSession = factory.openSession();
		BranchList = sqlSession.selectList("paymentsuccess_Branch", res_no);
		sqlSession.close();
		return BranchList;
	}
	public List<GroundDto> getsuccessGround(int res_no) {
		List<GroundDto> GroundList = null;
		SqlSession sqlSession = factory.openSession();
		GroundList = sqlSession.selectList("paymentsuccess_Ground", res_no);
		sqlSession.close();
		return GroundList;
	}
}
