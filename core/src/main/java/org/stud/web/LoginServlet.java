package org.stud.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangfeng542
 * @date 5/7/19
 */
@WebServlet(
	name = "loginServlet",urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet {

	private final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("将请求转发到登录页面");
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		String password = req.getParameter("password");

		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		String err = null;
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			err = "用户名或者密码错误.";
			LOGGER.error("登录失败",e);
		}

		if(StringUtils.hasText(err)){
			req.setAttribute("err",err);
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
		}else{
			req.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(req,resp);
		}
	}
}
