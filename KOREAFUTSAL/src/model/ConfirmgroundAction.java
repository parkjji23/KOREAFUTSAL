package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ConfirmgroundAction {
	static ConfirmgroundAction model = new ConfirmgroundAction();
	public static ConfirmgroundAction instance(){ //instance占쌨소드가 占쏙옙체占쏙옙 占쌓삼옙 占쏙옙爭�. 占싱깍옙占쏙옙占쏙옙占쏙옙, static(占쏙옙占쏙옙) 占싼뱄옙占쏙옙占쏙옙占싹몌옙 占쏙옙체占쏙옙占쏙옙占쏙옙占신곤옙째占시놂옙占� 占쏙옙占쏙옙占쏙옙
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); //SqlMapConfig占쏙옙 占쏙옙占쏙옙構渼占�

	public List<GroundDto> selectground(String ground_name){ //mapper占쏙옙占쏙옙 dto占쏙옙 resulttype占쏙옙占쏙옙 占싼곤옙占쏙옙占쏙옙占쏙옙, 占쌨억옙占쌕띰옙 占싱곤옙占쏙옙占쏙옙 List***占쏙옙 占쏙옙占승뤄옙 占쌨억옙占쏙옙 
		List<GroundDto> checkground=null;
		SqlSession sqlSession = factory.openSession();
		checkground = sqlSession.selectList("checkground",ground_name);
		sqlSession.close();
		return checkground;
	}

}
