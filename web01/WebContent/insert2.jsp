<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <% //스크립트 릿!
    // 자바코드 넣는 부분!!
    // HttpServletRequest request = new HttpServletRequest();
    // tomcat은 미리 request를 만들어서 내장시켜놨어요!
    //0. 클라이언트가 입력한 정보를 받아주세요!
    String title = request.getParameter("title"); //"1234"
    String content = request.getParameter("content"); //"apple"
    String writer = request.getParameter("writer"); //"010"
    
    //1, 받은 데이터를 dat에게 주기 위해서 가방을 만들어서 넣자.!
    BbsVO bag = new BbsVO();
    bag.setTitle(title);
    bag.setContent(content);
    bag.setWriter(writer);
    //2. dao에게 가방을 전달하면서 insert해달라고 하자.!
    BbsDAO dao = new BbsDAO();
    dao.insert(bag);
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
게시판 글쓰기 요청되었음.
<hr color="red">
작성한 title : <%=title%> <br>
작성한 content : <%=content%> <br>
작성한 writer : <%=writer%> <br>
</body>
</html>