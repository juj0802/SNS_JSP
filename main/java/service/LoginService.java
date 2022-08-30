package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import commons.BadRequestException;
import controllers.user.MemberValidator;
import models.user.UserInfoDao;
import models.user.UserInfoDto;

public class LoginService {
	public void login(HttpServletRequest request) {
		MemberValidator validator = new MemberValidator();
		UserInfoDao dao = new UserInfoDao();
		
		// 1. 필수 항목체크(아이디 - memId, 비밀번호 - memPw)
		Map<String, String> checkFields = new HashMap<>();
		checkFields.put("id", "아이디를 입력하세요.");
		checkFields.put("pw", "비밀번호를 입력하세요.");
		validator.requiredCheck(request, checkFields);
		
		String memId = request.getParameter("id");
		String memPw = request.getParameter("pw");
		
		// 2. 등록된 아이디 여부(회원 조회)
		UserInfoDto member = dao.get(memId);
		if (member == null) {
			throw new BadRequestException("등록된 회원 아이디가 아닙니다 - " + memId);
		}
		
		// 3. 비밀번호 검증
		boolean isMatched = BCrypt.checkpw(memPw, member.getPassword());
		if (!isMatched) {
			throw new BadRequestException("비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 회원 정보를 유지(세션)
		HttpSession session = request.getSession();
		
		member.setPassword(null);
		session.setAttribute("member", member);
	}
}
