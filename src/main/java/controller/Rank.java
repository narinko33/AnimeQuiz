package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RankingDAO;
import model.Ranking;


@WebServlet("/Rank")
public class Rank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RankingDAO dao = new RankingDAO();
		List<Ranking> rankList = dao.findAll();
		
		request.setAttribute("rankList", rankList);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ranking.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
