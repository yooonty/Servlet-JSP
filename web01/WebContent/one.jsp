<%@page import="multi.MemberVO"%>
<%@page import="multi.MemberDAO3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <% //스크립트 릿!
    // 자바코드 넣는 부분!!
    // HttpServletRequest request = new HttpServletRequest();
    // tomcat은 미리 request를 만들어서 내장시켜놨어요!
    String id = request.getParameter("id"); //"apple"
    
    //dao에게 id를 전달하자.!
    MemberDAO3 dao = new MemberDAO3();
    MemberVO rs = dao.one(id);
    
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
회원검색 요청되었음.
<hr color="red">
검색한 id : <%=rs.getId()%> <br>
검색한 pw : <%=rs.getPw()%> <br>
검색한 name : <%=rs.getName()%> <br>
검색한 tel : <%=rs.getTel()%> <br>
</body>
</html>