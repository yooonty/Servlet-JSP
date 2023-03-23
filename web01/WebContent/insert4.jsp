<%@ page import="multi.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bag" class="multi.MovieVO"></jsp:useBean>
<jsp:setProperty property="*" name="bag" />
<%
	MovieDAO dao = new MovieDAO();
	dao.insert(bag);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: #d2e6fa;
}
</style>
</head>
<body>
영화등록 요청되었음.
<hr color="red">
등록한 id : <%=bag.getId()%> <br>
등록한 title : <%=bag.getTitle()%> <br>
등록한 content : <%=bag.getContent()%> <br>
등록한 location : <%=bag.getLocation()%> <br>
등록한 director : <%=bag.getDirector()%> <br>
</body>
</html>