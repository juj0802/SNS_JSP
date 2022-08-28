package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String env = (bundle.getString("environment") == "production") ? "production" : "development";
			String path = "mybatis/config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(path);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, env);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}