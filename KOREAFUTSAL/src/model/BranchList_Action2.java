package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BranchList_Action2 {

	static BranchList_Action2 model = new BranchList_Action2();

	public static BranchList_Action2 instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<BranchDto> getBranchList(String id) {
	    List<BranchDto> BranchList = null;
		SqlSession sqlSession = factory.openSession();
		BranchList = sqlSession.selectList("branchlist_view2",id);
		sqlSession.close();
		return BranchList;
	}
	public List<BranchDto> getBranchList2(String branch_no) {
		
		List<BranchDto> BranchList2 = null;
		SqlSession sqlSession = factory.openSession();
		BranchList2 = sqlSession.selectList("branchdetail_view2",branch_no);
		sqlSession.close();
		System.out.println(BranchList2);
		return BranchList2;
	}

}
