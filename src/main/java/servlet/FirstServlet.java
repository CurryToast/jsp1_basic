package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 서블릿이 되기 위한 몇가지(추후 정리)
// URL이 필요합니다.
@WebServlet(urlPatterns={"/first.cc"}, description = "처음 만드는 서블릿")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로거를 작동시키기 위한 변수 선언 : 메소드 인자는 현재 클래스 이름
	private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
	
	public FirstServlet() {
		// TODO Auto-generated constructor stub
		super();
	}

	// get 요청을 처리하는 메소드
	// 인자 타입 2개. 요청과 응답에 대한 처리를 할 수 있습니다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 요청에 대한 정보 출력 (request 객체의 속성값) : 로그 출력에서 {}는 결과값 표시
		logger.info(
			"\n[MyInfo] : request URL : {}, URI : {}, 컨텍스트패스 : {}",
			request.getRequestURL(), request.getRequestURI(), request.getContextPath()
		);
		
		// 테스트 : 서블릿에서 html 출력 응답도 만들어 봅니다.
		// out은 jsp는 내장객체(선언없이 사용), 서블릿은 직접 생성(response 객체로 생성)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // response 객체의 출력스트림 생성
		out.print("<html>");
		out.print("<head><title>WELLCOME</title></head>");
		out.print("<body>");
		out.print("<h2>Hello World!</h2>");
		out.print("<p>현재 날짜와 시간 : " + LocalDateTime.now() + "</p>");
		out.print("</body>");
		out.print("</html>");
	}
}
