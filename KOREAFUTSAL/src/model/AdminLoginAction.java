package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class AdminLoginAction {
	static AdminLoginAction model = new AdminLoginAction();
	public static AdminLoginAction instance(){
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<AdminDto> login(AdminDto AdminDto){
		System.out.println("확인5");
		System.out.println("확인6"+AdminDto.getAdmin_id());
		System.out.println("확인6-1"+AdminDto.getAdmin_password());
		
		List<AdminDto> loginadmin=null;
		SqlSession sqlSession = factory.openSession();			
		loginadmin = sqlSession.selectList("AdminLogin",AdminDto);
		System.out.println(loginadmin);
		sqlSession.close();
		return loginadmin;
	}


}
