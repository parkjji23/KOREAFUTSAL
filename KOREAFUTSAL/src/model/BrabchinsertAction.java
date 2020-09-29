package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BrabchinsertAction {
	static BrabchinsertAction model = new BrabchinsertAction();

	public static BrabchinsertAction instance() { // instance占쌨소드가 占쏙옙체占쏙옙 占쌓삼옙 占쏙옙爭�. 占싱깍옙占쏙옙占쏙옙占쏙옙, static(占쏙옙占쏙옙) 占싼뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙체占쏙옙占쏙옙占쏙옙占신곤옙째占시놂옙占� 占쏙옙占쏙옙占쏙옙
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void insertinform(BranchDto BranchDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("Brabchinsert", BranchDto); // mapper.xml占쏙옙 ,<select> id
		sqlSession.commit();

		sqlSession.close();
	}
	
	public void insertinform2(BranchDto BranchDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("Brabchupdate",BranchDto); // mapper.xml占쏙옙 ,<select> id
		sqlSession.commit();

		sqlSession.close();
	}

}
