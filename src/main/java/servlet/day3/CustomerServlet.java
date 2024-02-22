package servlet.day3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

@WebServlet(urlPatterns = {"/customers.cc"}, description = "고객 전체 조회")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao 실행하고 list를 logger로 출력
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = dao.allCustomers();
		logger.info("::: 고객 전체 조회 :::\n{}", list);
		
		// 서블릿에서는 JDBC 관련된 실행만 하고 조회 결과는 jsp에서 웹페이지를 작성합니다.
		// 서블릿은 요청/응답 컨트롤러, jsp는 뷰(view)라고 부릅니다.
		
		// 뷰 jsp에 애트리뷰트 값을 저장해서 보내기
		// pageContext는 하나의 웹페이지 범위, requst는 하나의 요청 범위로 애트리뷰트 저장
		request.setAttribute("list", list);
		
		// 뷰 jsp로 요청을 전달하고 화면을 전환(forward)해야 합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/customers.jsp");
		dispatcher.forward(request, response);
		// 실행 브라우저 url: http://localhost:8080/jsp1/customers.cc
		// 화면의 웹페이지 : customers.jsp
	}
}
