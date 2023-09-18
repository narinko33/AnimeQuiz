package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDAO;
import model.Quiz;
import model.Ranking;

@WebServlet("/Play")
public class Play extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String updated = sdf.format(date);
		
		
		Ranking ranking = new Ranking(name,updated);
		HttpSession session = request.getSession();
		session.setAttribute("ranking", ranking);
		
		QuizDAO dao = new QuizDAO();
		List<Quiz> quizList = dao.getRandom();
		session.setAttribute("quizList", quizList);
		Integer quizNumber = 0;
		session.setAttribute("quizNumber", quizNumber);
		
		
		RequestDispatcher dr = request.getRequestDispatcher("WEB-INF/view/game.jsp");
		dr.forward(request, response);
	}

}
