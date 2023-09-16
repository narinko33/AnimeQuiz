<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Quiz, java.util.List, java.util.Random" %>
    <%
    List<Quiz> quizList = (List<Quiz>)session.getAttribute("quizList");
    Integer quizNumber  = (Integer)session.getAttribute("quizNumber");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>問題<%=quizNumber + 1 %></h1>
<form action="Judge" method="post">
<%=quizList.get(quizNumber).getText() %><br>
回答:<input type="text" name="answer"><br>
<input type="submit" value="ファイナルアンサー">
</form>
</body>
</html>