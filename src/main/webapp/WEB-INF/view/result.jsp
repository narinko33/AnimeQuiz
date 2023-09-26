<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*, java.util.List" %>
    <%
    Ranking ranking = (Ranking)session.getAttribute("ranking");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body style="background: linear-gradient(to right,#c70000,#d28300,#dfd000,#00873c,#005aa0,#181878,#800073)">
<h1>＜＜＜＜成績発表＞＞＞＞</h1>
名前:<%=ranking.getName() %><br>
遊んだ日:<%=ranking.getUpdated() %><br>
正解数:<%=ranking.getGood() %><br>
<a href="RankIn">戻る</a><br><br>
</body>
</html>