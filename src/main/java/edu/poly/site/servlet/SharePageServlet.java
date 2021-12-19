package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.Share;
import edu.poly.model.User;
import edu.poly.model.Video;


@WebServlet("/shareVideo")
public class SharePageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
				
		String videoId = request.getParameter("videoId");
		
		if(videoId == null) {
			response.sendRedirect("/Homepage");
			return;
		}
		
		request.setAttribute("videoId", videoId);		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_SHARE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddess = request.getParameter("email");
			String videoId = request.getParameter("videoId");
		
			
			if(videoId == null) {
				request.setAttribute("error", "VideoId is null!");
			}else {
				Email email = new Email();
				email.setFrom("hungnguyenvan209@gmail.com");
				email.setFromPassword("yourpassword");
				email.setTo(emailAddess);
				email.setSubject("Share Favorite Video");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Ms/Mr. <br>");
				sb.append("The video is more interesting and I want to share with you. <br>");
				sb.append("Please click the link").append(String.format("<a href=''>View Video </a> <br>", videoId));
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				ShareDao dao = new ShareDao();
				Share share = new Share();
				
				share.setEmails(emailAddess);
				share.setSharedDate(new Date());
				
				String username = SessionUtils.getLoginUsername(request);
				User user = new User();
				user.setUsername(username);
				
				share.setUser(user);
				Video video = new Video();
				video.setVideoId(videoId);
				share.setVideo(video);
				
				dao.insert(share);
				request.setAttribute("message", "Video link has been sent");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_SHARE_PAGE);
	}

}
