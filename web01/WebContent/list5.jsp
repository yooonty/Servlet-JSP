<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="multi.BookVO"%>
<%@page import="multi.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <% //스크립트 릿!
    BookDAO dao = new BookDAO();
    // 5,6) dao가 리턴한 BbsVO가 들어간 ArrayList를 받는다.
    ArrayList<BookVO> list = dao.list();
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
<h3>전체 책 갯수: <%=list.size() %></h3>
<body>
<hr color="orange">
<table class="table table-dark table-striped">
	<tr>
		<td>id</td>
		<td>title</td>
		<td>writer</td>
		<td>img</td>
	</tr>
<%
if(list.size()!=0){
	for(BookVO bag2: list){
%>
	<tr>
	
		<td>
		<a href="one5.jsp?no=<%=bag2.getNo()%>">
			<%=bag2.getNo()%>
		</a>
		</td>
		<td><%=bag2.getTitle()%></td>
		<td><%=bag2.getWriter()%></td>
		<td><img alt="책사진" src="img/<%=bag2.getImg()%>" width="100" height="100"></td>
	</tr>	
<%
	}
}
%>
</table>
</body>
</html>