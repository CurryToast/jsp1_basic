package servlet.day3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

@WebServlet(urlPatterns = {"/register.cc"}, description = "고객 등록")
public class RegisterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> customerCols = new HashMap<String, String>();
		customerCols.put("custom_id", "고객 아이디");
		customerCols.put("name", "이름");
		customerCols.put("email", "이메일");
		customerCols.put("age", "나이");

		request.setAttribute("customerCols", customerCols);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		TblCustomerDao dao = new TblCustomerDao();
		int result = dao.join(new CustomerVo(
			request.getParameter("custom_id"),
			request.getParameter("name"),
			request.getParameter("email"),
			Integer.parseInt(request.getParameter("age")),
			null
		));
		
		request.setAttribute("registerResult", result);

		// 서버가 클라이언트에게 "customers.cc로 요청을 보내라."라는 응답을 보냅니다.
		// 리다이렉트는 웹페이지의 자바스크립트, out.print 출력을 못합니다.
		response.sendRedirect("customers.cc");
	}
}
