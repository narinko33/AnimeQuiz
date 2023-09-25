<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Quiz, java.util.List, java.util.Random" %>
    <%
    List<Quiz> quizList = (List<Quiz>)session.getAttribute("quizList");
    Integer quizNumber  = (Integer)session.getAttribute("quizNumber");
    String badMsg = (String)request.getAttribute("badMsg");
    String goodMsg = (String)request.getAttribute("goodMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(goodMsg != null ) { %>
<p><font color="green"><%= goodMsg %></font></p>
<% } else if(badMsg != null) {%>
<p><font color="red"><%= badMsg %></font></p>
<% } else {%>
<% } %>
<h1>問題<%=quizNumber + 1 %></h1>
<form action="Judge" method="post">
<%=quizList.get(quizNumber).getText() %><br>
選択肢<br>
<%=quizList.get(quizNumber).getSelect() %><br>
回答:<button name="answer" value="1">1</button>
<button name="answer" value="2">2</button>
<button name="answer" value="3">3</button><br>
</form>
</body>
</html>