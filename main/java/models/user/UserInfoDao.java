package models.user;

import commons.SQLInsert;
import commons.SQLUpdate;

public class UserInfoDao implements SQLInsert, SQLUpdate {
	
	public boolean register(UserInfoDto dto) {
		
		boolean result = this.<UserInfoDto>insert(dto, "UserInfoMapper.register");
		
		return result;
	}
	
	
}
