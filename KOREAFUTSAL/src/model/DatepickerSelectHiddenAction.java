package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;


public class DatepickerSelectHiddenAction {
	static DatepickerSelectHiddenAction model = new DatepickerSelectHiddenAction();
	public static DatepickerSelectHiddenAction instance(){ //instance�޼ҵ尡 ��ü�� �׻� ��. �̱�������, static(����) �ѹ������ϸ� ��ü�������Ű�°�ó�� ������
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); //SqlMapConfig�� ����ϰڴ�
	public List<ComResInfoDto> datepickerselecthidden(ComResInfoDto ComResInfoDto){
		List<ComResInfoDto> ComResInfoList=null;
		SqlSession sqlSession = factory.openSession();
		ComResInfoList = sqlSession.selectList("datepicker_selecthidden",ComResInfoDto);
		sqlSession.close();
		return ComResInfoList;
	}

}

