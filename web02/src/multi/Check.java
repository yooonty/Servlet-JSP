package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check.do")
public class Check extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 만들 때, 패스워드가 안맞으면 어떻게 할지 지정!
		System.out.println("Check 서블릿 객체가 하나 만들어진다.!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Check 서블릿 객체가 소멸됨.");
	}
	
	// get요청, 클라이언트로 부터 전달되는 데이터는 주소와 함께 도착
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String today = request.getParameter("today");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (today.equals("맑음")) {
			out.print("나가자.");
		} else if (today.equals("흐림")) {
			out.print("코딩");
		} else if (today.equals("비옴")) {
			out.print("쇼핑");
		} else {
			out.print("그냥있자.");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("post요청을 받음>> " + pass);
		if (pass.equals("나는왕이다.")) {
			out.print("들어오세요.<img src='yes.jpg' width=200 height=200>");
		} else {
			out.print("들어올 수 없습니다.<img src='no.png' width=200 height=200>");
		}
		out.close();
	}

}
