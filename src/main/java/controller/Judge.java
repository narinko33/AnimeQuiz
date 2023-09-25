package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RankingDAO;
import model.Quiz;
import model.Ranking;


@WebServlet("/Judge")
public class Judge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("answer");
		HttpSession session = request.getSession();
		List<Quiz> quizList = (List<Quiz>)session.getAttribute("quizList");
		Integer quizNumber  = (Integer)session.getAttribute("quizNumber");
		Ranking ranking = (Ranking)session.getAttribute("ranking");
		
		
		if(answer.equals(quizList.get(quizNumber).getAnswer())) {
			
			request.setAttribute("goodMsg", "正解！！");
			ranking.addGood();
		} else {
			request.setAttribute("badMsg", "不正解！！");
		}
		
		quizNumber++;
		session.setAttribute("quizNumber", quizNumber);
		
		if(quizNumber == 10) {
			
			RankingDAO dao = new RankingDAO();
			dao.insertOne(ranking);
			
			RequestDispatcher dr = request.getRequestDispatcher("WEB-INF/view/result.jsp");
			dr.forward(request, response);
			
		}
		
		RequestDispatcher dr = request.getRequestDispatcher("WEB-INF/view/game.jsp");
		dr.forward(request, response);
	}

}
