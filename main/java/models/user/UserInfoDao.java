package models.user;

import org.apache.ibatis.session.SqlSession;

import commons.SQLInsert;
import commons.SQLUpdate;
import mybatis.Connection;

public class UserInfoDao implements SQLInsert, SQLUpdate {
	
	public boolean register(UserInfoDto dto) {
	
		boolean result = this.<UserInfoDto>insert(dto, "UserInfoMapper.register");
		
		return result;
	}
	
	public UserInfoDto get(String id) {
		SqlSession session = Connection.getSession();
		UserInfoDto dto = new UserInfoDto();
		dto.setId(id);
		UserInfoDto member = session.selectOne("UserInfoMapper.select",dto);
		session.close();
		return member;
	}
	
	
}
