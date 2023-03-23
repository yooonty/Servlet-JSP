<%@page import="multi.ProductDAO"%>
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
    
    ProductDAO dao = new ProductDAO();
    dao.delete(id);
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
상품 삭제 요청되었음.
<hr color="red">
삭제할 id : <%=id%> <br>
</body>
</html>