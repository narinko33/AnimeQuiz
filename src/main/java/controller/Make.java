package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuizDAO;
import model.Quiz;

@WebServlet("/Make")
public class Make extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuizDAO dao = new QuizDAO();
		dao.connectCheck();
		List<Quiz> quizList = dao.findAll();
		System.out.println(quizList.size());
		request.setAttribute("quizList", quizList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("make.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		String answer = request.getParameter("answer");
		
		QuizDAO dao = new QuizDAO();
		
		if (text != null && text.length() != 0 && answer != null && answer.length() != 0) {
			Quiz quiz = new Quiz(text,answer);
			dao.insertOne(quiz);
		} else {
			request.setAttribute("errorMsg", "どちらかが未入力です！！");
		}
		List<Quiz>quizList = dao.findAll();
		request.setAttribute("quizList", quizList);
		
		RequestDispatcher rd = request.getRequestDispatcher("make.jsp");
		rd.forward(request, response);
	}

}
