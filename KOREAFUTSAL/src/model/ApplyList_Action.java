package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ApplyList_Action {
	
	static ApplyList_Action model = new ApplyList_Action();
	public static ApplyList_Action instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


	public List<PlayerRegistDto> getLeader(PlayerRegistDto Player){
		List<PlayerRegistDto> Applyer = null;
		System.out.println("PlayerApply_Ation 에서 Player 잘 넘어왔는지 Player의 팀 코드"+Player.getT_code());
		PlayerRegistDto obb = Player;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		SqlSession sqlSession = factory.openSession();			
		Applyer = sqlSession.selectList("leader_check",obb);
		sqlSession.close();
		return Applyer;
	}
	
	public List<PlayerRegistDto> getApplyer(PlayerRegistDto Player){
		List<PlayerRegistDto> Applyer = null;
		System.out.println("PlayerApply_Ation 에서 Player 잘 넘어왔는지 Player의 팀 코드"+Player.getT_code());
		PlayerRegistDto obb = Player;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		
		SqlSession sqlSession = factory.openSession();			
		Applyer = sqlSession.selectList("team_apply_list",obb);
		sqlSession.close();
		return Applyer;
	}
	
	public List<MemberDto> getMember(PlayerRegistDto applyer){
		List<MemberDto> Member = null;
		
		PlayerRegistDto obb = applyer;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		
		SqlSession sqlSession = factory.openSession();			
		Member = sqlSession.selectList("team_apply_member_list",obb);
		sqlSession.close();
		return Member;
	}
	


}
