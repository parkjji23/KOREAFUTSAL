package model;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class NoticeboardList_Action {

	static NoticeboardList_Action model = new NoticeboardList_Action();

	public static NoticeboardList_Action instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	
	
	
	
	public void noticeboard_readcount(NoticeboardDto NoticeDto) {
	   // int noticeboard_readcount = (Integer) null;
		NoticeboardDto obb = NoticeDto;
		SqlSession sqlSession = factory.openSession();
		
		int noticeboard_readcount = sqlSession.update("noticeboard_readcount",obb);
		sqlSession.commit();
		System.out.println(noticeboard_readcount);
		
		
		sqlSession.close();

	}
		
	public void noticeboard_insert(NoticeboardDto NoticeDto) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("noticeboard_insert", NoticeDto); //
		sqlSession.commit();

		sqlSession.close();
	}
	public List<NoticeboardDto> getNoticeboardList(String a) {
	    List<NoticeboardDto> noticeboardList = null;
		SqlSession sqlSession = factory.openSession();
		noticeboardList = sqlSession.selectList("noticeboardList3",a);
		sqlSession.close();
		return noticeboardList;
	}



	public List<NoticeboardDto> getNoticeboardList2(int n_num) {
		List<NoticeboardDto> noticeboardList2 = null;
	   
		SqlSession sqlSession = factory.openSession();
		noticeboardList2 = sqlSession.selectList("noticeboardList_view2",n_num);
		//noticeboard_readcount=sqlSession.update("noticeboard_readcount",n_num);
		System.out.println(noticeboardList2);
	//	System.out.println(noticeboard_readcount);
		
		
		sqlSession.close();
		return noticeboardList2;
	}


     
	public List<NoticeboardDto> getNoticeboardList() {
	    List<NoticeboardDto> noticeboardList = null;
		SqlSession sqlSession = factory.openSession();
		noticeboardList = sqlSession.selectList("noticeboardList");
		sqlSession.close();
		return noticeboardList;
	}

}
