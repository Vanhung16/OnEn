package edu.poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.JpaUtils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Favorite;
import edu.poly.model.Video;



/**
 * Servlet implementation class FavoritePageServlet
 */
@WebServlet("/FavoritePage")
public class FavoritePageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JpaUtils.getEntityManager();
		
		String username = SessionUtils.getLoginUsername(request);
		
		String jpql = "select u from Video u where u.videoId not in ("
				+ "select f.videoId from Favorite f inner join User f on f.user = f.username where f.user = :username) ";
		List<Video> list = null;
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			
			query.setParameter("username", username);
			list = query.getResultList();
			request.setAttribute("fvList", list);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_FAVORITE_PAGE);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
