package model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ReservationList_Action {
	static ReservationList_Action model = new ReservationList_Action();

	public static ReservationList_Action instance() {
		return model;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<ReservationDto> getReservationList(String id) {
		List<ReservationDto> reservationlist = null;
		SqlSession sqlSession = factory.openSession();
		reservationlist = sqlSession.selectList("reservationlist",id);
		sqlSession.close();
		return reservationlist;
	}
	public List<BranchDto> getReservationListBranch(String id) {
		List<BranchDto> BranchList = null;
		SqlSession sqlSession = factory.openSession();
		BranchList = sqlSession.selectList("reservationlist_Branch", id);
		sqlSession.close();
		return BranchList;
	}
	public List<GroundDto> getReservationListGround(String id) {
		List<GroundDto> GroundList = null;
		SqlSession sqlSession = factory.openSession();
		GroundList = sqlSession.selectList("reservationlist_Ground", id);
		sqlSession.close();
		return GroundList;
	}
}
