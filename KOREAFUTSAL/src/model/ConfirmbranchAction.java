
package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ConfirmbranchAction {
	static ConfirmbranchAction model = new ConfirmbranchAction();
	public static ConfirmbranchAction instance(){ //instance�޼ҵ尡 ��ü�� �׻� ��. �̱�������, static(����) �ѹ������ϸ� ��ü�������Ű�°�ó�� ������
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); //SqlMapConfig�� ����ϰڴ�

	public List<BranchDto> selectbrabch(String branch_name){ //mapper���� dto�� resulttype���� �Ѱ�������, �޾��ٶ� �̰����� List***�� ���·� �޾��� 
		List<BranchDto> checkbrabch=null;
		SqlSession sqlSession = factory.openSession();
		checkbrabch = sqlSession.selectList("checkbrabch",branch_name);
		sqlSession.close();
		return checkbrabch;
	}

}
