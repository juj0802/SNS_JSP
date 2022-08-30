package controllers.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import commons.BadRequestException;
import models.user.UserInfoDao;
import models.user.UserInfoDto;
import service.LoginService;
import static commons.Utils.*;
@WebServlet("/user/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginService service = new LoginService();
			service.login(req);
			
			/** 아이디 저장 S */
			if (req.getParameter("saveId") == null) { // 아이디 저장 쿠기 삭제
				Cookie[] cookies = req.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("saveId")) {
						cookie.setMaxAge(0);
					}
				}
			} else { // 아이디 저장 
				String memId = req.getParameter("id");
				Cookie saveMemId = new Cookie("saveId", memId);
				saveMemId.setMaxAge(60 * 60 * 24 * 365);
				resp.addCookie(saveMemId);
			}
			/** 아이디 저장 E */
			
			RequestDispatcher rd = req.getRequestDispatcher("/user/main.jsp");
			rd.forward(req, resp);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			alertError(resp, e,"history.back();");
		}
		
	}

}
