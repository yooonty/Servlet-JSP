<%@ page import="multi.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bag" class="multi.BookVO"></jsp:useBean>
<jsp:setProperty property="*" name="bag" />
<%
	BookDAO dao = new BookDAO();
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
책등록 요청되었음.
<hr color="red">
등록한 no : <%=bag.getNo()%> <br>
등록한 title : <%=bag.getTitle()%> <br>
등록한 content : <%=bag.getContent()%> <br>
등록한 writer : <%=bag.getWriter()%> <br> 
등록한 img: <br>
<img alt="책 사진" src="img/<%=bag.getImg()%>" width="200" height="200"> <br>
</body>
</html>