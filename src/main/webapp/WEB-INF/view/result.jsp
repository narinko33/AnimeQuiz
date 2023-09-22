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
</head>
<body>
名前:<%=ranking.getName() %>
遊んだ日:<%=ranking.getUpdated() %>
正解数:<%=ranking.getGood() %>

</body>
</html>