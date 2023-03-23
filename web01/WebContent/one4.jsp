<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <% //스크립트 릿!
    // 자바코드 넣는 부분!!
    // HttpServletRequest request = new HttpServletRequest();
    // tomcat은 미리 request를 만들어서 내장시켜놨어요!
    // 클라이언트가 입력한 No를 서저에서 
    String id = request.getParameter("id"); //"apple"
    // JSP안에 만들어진 변수는 서버의 RAM에 저장되는 지역변수!
    
    MovieDAO dao = new MovieDAO();
    MovieVO bag = dao.one(id);
    %>
    <!-- 3.브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
	background: #d2e6fa;
}
</style>
</head>
<body>
영화 검색 요청되었음.
<hr color="red">
검색을 원하는 id : <%=id%> <br>
<hr color="orange">
<table class="table table-dark table-striped">
	<tr>
		<td>검색한 title</td>
		<td><%=bag.getTitle()%></td>
	</tr>
	<tr>
		<td>검색한 content</td>
		<td><%=bag.getContent()%></td>
	</tr>
	<tr>
		<td>검색한 location</td>
		<td><%=bag.getLocation()%></td>
	</tr>
	<tr>
		<td>검색한 director</td>
		<td><%=bag.getDirector()%></td>
	</tr>
</table>

</body>
</html>