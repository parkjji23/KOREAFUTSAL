package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ReservationClick_Action {
	static ReservationClick_Action model = new ReservationClick_Action();

	public static ReservationClick_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<GroundDto> reservation_ground(String branch_no) {
		List<GroundDto> GroundList = null;
		SqlSession sqlSession = factory.openSession();
		GroundList = sqlSession.selectList("click_ground_reservation", branch_no);
		sqlSession.close();
		return GroundList;
	}
	
	public List<BranchDto> reservation_branch(String branch_no) {
		List<BranchDto> BranchList = null;
		SqlSession sqlSession = factory.openSession();
		BranchList = sqlSession.selectList("click_branch_reservation", branch_no);
		sqlSession.close();
		return BranchList;
	}
	
	public List<ReservationDto> getbookedDate(String branch_no) {
		List<ReservationDto> ReservationList = null;
		SqlSession sqlSession = factory.openSession();
		ReservationList = sqlSession.selectList("unavailable_nodatetime_pick", branch_no);
		sqlSession.close();
		return ReservationList;
	}
	
	public List<ComResInfoDto> getfulldate(ComResInfoDto comResInfoDto) {
		List<ComResInfoDto> fulldatelist = null;
		SqlSession sqlSession = factory.openSession();
		fulldatelist = sqlSession.selectList("fulldate_select", comResInfoDto);
		sqlSession.close();
		return fulldatelist;
	}
}
