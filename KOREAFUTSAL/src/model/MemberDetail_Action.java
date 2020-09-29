
package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDetail_Action {
	static MemberDetail_Action model = new MemberDetail_Action();
	public static MemberDetail_Action instance(){
		return model;
	}

		private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


		public List<GroundDto> getGroundDetail(String branch_no){
			List<GroundDto> GroundList = null;
			SqlSession sqlSession = factory.openSession();			
			GroundList = sqlSession.selectList("grounddetail_view",branch_no);
			sqlSession.close();
			return GroundList;
		}
		
		public List<BranchDto> getBranchDetail(String branch_no){
			List<BranchDto> BranchList = null;
			SqlSession sqlSession = factory.openSession();			
			BranchList = sqlSession.selectList("branchdetail_view",branch_no);
			sqlSession.close();
			return BranchList;
		}
		public List<MemberDto> getBranchList2(){
			List<MemberDto> MemberList = null;
			SqlSession sqlSession = factory.openSession();			
			MemberList = sqlSession.selectList("memberlist_view");
			System.out.println(MemberList);
			sqlSession.close();
			return MemberList;
		}
		public List<MemberDto> getMemberDetail(String id){
			System.out.println("아이디는?"+id);
			List<MemberDto> MemberList = null;
			SqlSession sqlSession = factory.openSession();			
			MemberList = sqlSession.selectList("memberdetail_view",id);
		
		
			sqlSession.close();
			return MemberList;
		}
}