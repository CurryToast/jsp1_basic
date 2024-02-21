package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿이 되기 위한 몇가지(추후 정리)
// URL이 필요합니다.
@WebServlet(urlPatterns={"/first.cc"}, name="/first.cc")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FirstServlet() {
		// TODO Auto-generated constructor stub
		super();
	}

	// get 요청을 처리하는 메소드
	// 인자 타입 2개. 요청과 응답에 대한 처리를 할 수 있습니다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
