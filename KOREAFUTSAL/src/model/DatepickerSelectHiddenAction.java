package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;


public class DatepickerSelectHiddenAction {
	static DatepickerSelectHiddenAction model = new DatepickerSelectHiddenAction();
	public static DatepickerSelectHiddenAction instance(){ //instance메소드가 객체를 항상 뱉어냄. 싱글톤패턴, static(정적) 한번실행하면 전체를실행시키는것처럼 느껴짐
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); //SqlMapConfig를 사용하겠다
	public List<ComResInfoDto> datepickerselecthidden(ComResInfoDto ComResInfoDto){
		List<ComResInfoDto> ComResInfoList=null;
		SqlSession sqlSession = factory.openSession();
		ComResInfoList = sqlSession.selectList("datepicker_selecthidden",ComResInfoDto);
		sqlSession.close();
		return ComResInfoList;
	}

}

