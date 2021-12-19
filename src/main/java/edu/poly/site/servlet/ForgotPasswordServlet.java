package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.jni.Address;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.User;

/**
 * Servlet implementation class RegistrationpageServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddess = request.getParameter("email");
			String username = request.getParameter("username");
		
			UserDao dao = new UserDao();
			User user = dao.findByUsernameAndEmail(username, emailAddess);
			
			if(user == null) {
				request.setAttribute("error", "username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("hungnguyenvan209@gmail.com");
				email.setFromPassword("yourpassword");
				email.setTo(emailAddess);
				email.setSubject("Forgot Password Fuction");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("you are used the forgot password function. <br>");
				sb.append("Your password is <b>").append(user.getPassword()).append("<br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("message", "Email sent to "
						+ "the mail Address. Pleasee check and get your password");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
