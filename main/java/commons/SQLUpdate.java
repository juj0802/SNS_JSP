package commons;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public interface SQLUpdate {
	default <T> boolean update(T dto, String mapperId) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.update(mapperId, dto);
		
		sqlSession.commit();
		sqlSession.close();
		
		return affectedRows > 0;
	}
}
