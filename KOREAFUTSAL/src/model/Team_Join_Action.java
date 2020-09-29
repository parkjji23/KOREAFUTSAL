package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Team_Join_Action {
	
	static Team_Join_Action model = new Team_Join_Action();
	public static Team_Join_Action instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();


	public void approval(PlayerRegistDto Player){
		int Applyer = 0;
		System.out.println("PlayerApply_Ation 에서 Player 잘 넘어왔는지 Player의 팀 코드"+Player.getT_code());
		PlayerRegistDto obb = Player;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		SqlSession sqlSession = factory.openSession();			
		Applyer = sqlSession.insert("join_success",obb);
		sqlSession.delete("join_fail",obb);
		sqlSession.commit();
		sqlSession.close();

	}
	
	public void refusal(PlayerRegistDto Player){
		int Applyer = 0;
		System.out.println("PlayerApply_Ation 에서 Player 잘 넘어왔는지 Player의 팀 코드"+Player.getT_code());
		PlayerRegistDto obb = Player;
		System.out.println("obb에 teamcode 담기는지 확인"+obb.getT_code());
		
		SqlSession sqlSession = factory.openSession();			
		Applyer = sqlSession.delete("join_fail",obb);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	


}
