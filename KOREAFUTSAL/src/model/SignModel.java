package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import vo.QnaDto;

public class SignModel {
	
	static SignModel model = new SignModel();
	public static SignModel instance(){ //instance �޼ҵ尡 �� ��ü�� �����ϴ� �� �̰��� �̱��� ���� !
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();           // Map �� �ִ� sqlSession factory ���ڴ� �Ʊ� Map.java(SqlMapConfig �� ã�ư��� ����.)

	public List<MemberDto> selectMember(String arg){
		List<MemberDto> list = null;
		System.out.println(arg);
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectMember", arg);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		
		System.out.println("ȸ�� ������ : "+list.size());
		sqlSession.close();
		return list;
	}
	
	public MemberDto insertSangpum(MemberDto sangpum){
	
		MemberDto obb =   sangpum;
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.insert("insertSangpum",obb);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		sqlSession.commit();
	//	System.out.println("���� result : "+result+"�Է� �����"+obb.getGB_CONTENTS()+" "+obb.getGB_SUBJECT()+" "+obb.getGB_ID()+" "+obb.getGB_FILE());
		sqlSession.close();
		return obb;
	}
	public MemberDto modifySign(MemberDto member){
		System.out.println("ȸ������");
		MemberDto obb =   member;
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.update("modifySign",obb);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		sqlSession.commit();
	//	System.out.println("���� result : "+result+"�Է� �����"+obb.getGB_CONTENTS()+" "+obb.getGB_SUBJECT()+" "+obb.getGB_ID()+" "+obb.getGB_FILE());
		sqlSession.close();
		return obb;
	}
	public MemberDto modifyPw(MemberDto member){
		System.out.println("�������");
		MemberDto obb =   member;
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.update("modifyPw",obb);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		sqlSession.commit();
	//	System.out.println("���� result : "+result+"�Է� �����"+obb.getGB_CONTENTS()+" "+obb.getGB_SUBJECT()+" "+obb.getGB_ID()+" "+obb.getGB_FILE());
		sqlSession.close();
		return obb;
	}
	public MemberDto delSign(MemberDto member){
		System.out.println("ȸ������");
		MemberDto obb =   member;
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.delete("delSign",obb);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		sqlSession.commit();
		
		sqlSession.close();
		return obb;
	}
	public List<QnaDto> selectQnaSearch(QnaDto board){ //qna �˻�
		List<QnaDto> list = null;
		QnaDto obb = board;
		System.out.println("obb�� board�� ������ Ȯ�� ������"+obb.getQ_b_title()+obb.getQ_b_email());
		SqlSession sqlSession = factory.openSession();
		if(obb.getQ_b_email().equals("qTitle")) {
			list = sqlSession.selectList("qnatitle", obb);       // sqlSession �� �ҷ��� DB�� ���ǵ� �ű⼭ selectList ����. mapper ���Ͽ��� �±� �̸� ! 
		}
		else if(obb.getQ_b_email().equals("qContents")) {
			list = sqlSession.selectList("qnacontents", obb);  
		}
		System.out.println("�˻��Խù� ������ : "+list.size());
		sqlSession.close();
		return list;
	}
	
}
