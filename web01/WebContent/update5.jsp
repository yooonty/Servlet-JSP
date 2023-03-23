<%@page import="multi.BookDAO"%>
<%@page import="multi.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <jsp:useBean id="bag" class="multi.BookVO"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
    <% //스크립트 릿!
    // 자바코드 넣는 부분!!
    // HttpServletRequest request = new HttpServletRequest();
    // tomcat은 미리 request를 만들어서 내장시켜놨어요!
    BookDAO dao = new BookDAO();
    dao.update(bag);
    %>
    <!-- 3.브라우저에게 결과를 알려주기 위한 html코드가 미리 들어가 있음. -->
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
책 수정 요청되었음.
<hr color="red">
수정할 no : <%=bag.getNo()%> <br>
수정할 content : <%=bag.getContent()%> <br>
</body>
</html>