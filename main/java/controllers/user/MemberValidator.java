package controllers.user;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import commons.BadRequestException;
import models.user.UserInfoDto;
import mybatis.Connection;

public class MemberValidator {
	public void duplicateMember(String memId) {
		SqlSession sqlSession = Connection.getSession();
		UserInfoDto param = new UserInfoDto();
		param.setId(memId);
		
		int count = sqlSession.selectOne("MemberMapper.count", param);
		
		sqlSession.close();
		
		if (count > 0) {
			throw new BadRequestException("이미 등록된 회원 아이디입니다.");
		}
	}
	
	public void checkMemId(String memId) {
		if (memId.length() < 6) {
			throw new BadRequestException("아이디는 6자리 이상 입력하세요.");
		}
		
		Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(memId);
		if (matcher.find()) { // 숫자, 알파벳이 아닌 문자가 포함되어 있는 경우
			throw new BadRequestException("아이디는 알파벳과 숫자로만 입력하세요.");
		}
	}
	
	public void checkMemPw(String memPw) {
		if (memPw.length() < 8) {
			throw new BadRequestException("비밀번호는 8자리 이상 입력하세요.");
		}
	}

public void requiredCheck(HttpServletRequest request, Map<String, String> fields) {
		
		for (Map.Entry<String, String> entry : fields.entrySet()) {
			String value = request.getParameter(entry.getKey());
			String msg = entry.getValue(); // 오류 메세지 
			if (value == null || value.isBlank()) {
				throw new BadRequestException(msg);
			}
		}
	}
}
