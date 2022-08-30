package commons;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Utils {
	public static void alertError(HttpServletResponse response, RuntimeException e, String addScript) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			if (addScript == null) addScript = "";
			
			out.printf("<script>alert('%s');%s</script>", e.getMessage(), addScript);
			
		} catch (Exception _e) {}
	}
	public static void alertError(HttpServletResponse response, RuntimeException e) {
		alertError(response, e, null);
	}
}
