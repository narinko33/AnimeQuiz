<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Ranking, java.util.List" %>
    <%
    List<Ranking> rankList =
    		(List<Ranking>)request.getAttribute("rankList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ランキング</h1>
<table border="1">
<tr><th>名前</th><th>正解数</th><th>日付</th></tr>
<% for (Ranking ranking : rankList) { %>
<tr><td><%= ranking.getName() %></td><td><%= ranking.getGood() %></td><td><%= ranking.getUpdated() %></td></tr>
<% } %>
<a href="index.jsp">戻る</a><br><br>
</table>
</body>
</html>