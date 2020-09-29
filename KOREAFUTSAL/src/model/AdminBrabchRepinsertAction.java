package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class AdminBrabchRepinsertAction {
	static AdminBrabchRepinsertAction model = new AdminBrabchRepinsertAction();

	public static AdminBrabchRepinsertAction instance() { // instance占쌨소드가 占쏙옙체占쏙옙 占쌓삼옙 占쏙옙爭�. 占싱깍옙占쏙옙占쏙옙占쏙옙,
															// static(占쏙옙占쏙옙) 占싼뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙체占쏙옙占쏙옙占쏙옙占신곤옙째占시놂옙占�
															// 占쏙옙占쏙옙占쏙옙
		
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public void insertinform(AdminBranchRepDto AdminBranchRepDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("AdminBranchRepinsert", AdminBranchRepDto); // mapper.xml占쏙옙 ,<select> id
		sqlSession.commit();

		sqlSession.close();
	}
	
	public List<AdminBranchRepDto> getAdminBranchRep(String branch_no) {
		List<AdminBranchRepDto> AdminBranchRepList = null;
		SqlSession sqlSession = factory.openSession();
		AdminBranchRepList = sqlSession.selectList("AdminBranchRepselect", branch_no);
		sqlSession.close();
		return AdminBranchRepList;

	}
}
