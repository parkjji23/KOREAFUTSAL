package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class PlayerApply_Action {
	
	static PlayerApply_Action model = new PlayerApply_Action();
	public static PlayerApply_Action instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	int applyer=0;


	public void getApplyer(PlayerRegistDto Player){
		System.out.println("PlayerApply_Ation ���� Player �� �Ѿ�Դ��� Player�� �� �ڵ�"+Player.getT_code());
		PlayerRegistDto obb = Player;
		System.out.println("obb�� teamcode ������ Ȯ��"+obb.getT_code());
		System.out.println("obb�� id ������ Ȯ��"+obb.getId());
		SqlSession sqlSession = factory.openSession();			
		applyer = sqlSession.insert("team_apply",obb);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	


}
