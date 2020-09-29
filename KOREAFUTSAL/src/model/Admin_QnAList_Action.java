package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.QnaDto;

public class Admin_QnAList_Action {

	static Admin_QnAList_Action model = new Admin_QnAList_Action();

	public static Admin_QnAList_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	public List<QnaDto> Qnaviewlist() {
		List<QnaDto> Qnalist = null;
		SqlSession sqlSession = factory.openSession();
		Qnalist = sqlSession.selectList("AdminQnaListview");
		sqlSession.close();
		return Qnalist;
	}
	
	public List<QnaDto> Qnaviewdetail(int q_b_no) {
		List<QnaDto> QnaDetaillist = null;
		SqlSession sqlSession = factory.openSession();
		QnaDetaillist = sqlSession.selectList("AdminQnaDetailview",q_b_no);
		sqlSession.close();
		return QnaDetaillist;
	}
}