package commons;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public interface SQLInsert {
	
	default <T> boolean insert(T dto, String mapperId) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.insert(mapperId, dto);
		
		sqlSession.commit();
		sqlSession.close();
		
		return affectedRows > 0;
	}
}