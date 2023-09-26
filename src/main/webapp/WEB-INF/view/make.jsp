<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Quiz, java.util.List" %>
    <%
    List<Quiz> quizList =
    		(List<Quiz>)request.getAttribute("quizList");
    
    String errorMsg = (String)request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>問題作成</h1>
<h2>*注意*<br>
作成の際、選択肢は3つ以外にはしないこと。<br>
</h2>
<form action="Make" method="post">
問題文:<br>
<textarea name="text" rows="8" cols="40"></textarea><br><br>
選択肢：<br>
<textarea name="select" rows="4" cols="40" >1  
2  
3  </textarea><br><br>
答え:<br>
<select name="answer">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select>
<input type="submit" value="登録" ><br>
</form>
<% if(errorMsg != null) { %>
<p><font color="red"><%= errorMsg %></font></p>
<% } %>
<table border="1">
<tr><th>問題文</th><th>選択肢</th><th>答え</th></tr>
<% for (Quiz quiz : quizList) { %>
<tr><td><%= quiz.getText() %></td><td><%= quiz.getSelect() %></td><td><%= quiz.getAnswer() %></td></tr>
<% } %>
<a href="index.jsp">戻る</a><br><br>
</table>
</body>
</html>