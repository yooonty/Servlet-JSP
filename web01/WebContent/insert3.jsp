<%@page import="multi.ProductDAO"%>
<%@page import="multi.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 브라우저가 보낸 데이터를 받아야 함, ==> 자바로 짜야함. -->
    <!-- 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
    <jsp:useBean id="bag" class="multi.ProductVO"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
    
    <% //스크립트 릿!
    // 자바코드 넣는 부분!!
    // HttpServletRequest request = new HttpServletRequest();
    // tomcat은 미리 request를 만들어서 내장시켜놨어요!
    /* String id = request.getParameter("id");
    String name = request.getParameter("name"); 
    String content = request.getParameter("content"); 
    String price = request.getParameter("price");
    String company = request.getParameter("company");
    String img = request.getParameter("img"); */
    int result = 0; 
    
    // 가방을 만들어서 값들을 넣고(set)!
    // jsp에서 자동 import - 해당클래스 클릭한 다음 컨트롤 + 쉬프트 + m
	/* ProductVO bag = new ProductVO();
    bag.setId(id);
    bag.setName(name);
    bag.setContent(content);
    bag.setPrice(Integer.parseInt(price));
    bag.setCompany(company);
    bag.setImg(img); */
    
    //dao에게 가방을 전달하자.!
    ProductDAO dao = new ProductDAO();
    result = dao.insert(bag);
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
상품등록 요청되었음.
<hr color="red">
등록한 id : <%=bag.getId()%> <br>
등록한 name : <%=bag.getName()%> <br>
등록한 content : <%=bag.getContent()%> <br>
등록한 price : <%=bag.getPrice()%> <br>
등록한 company : <%=bag.getCompany()%> <br>
등록한 img <br>
<img alt="상품 사진" src="img/<%=bag.getImg()%>" width="200" height="200"> <br>
</body>
</html>