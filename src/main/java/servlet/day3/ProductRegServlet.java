package servlet.day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVo;

@WebServlet(urlPatterns = {"/productReg.cc"}, description = "상품 등록")
public class ProductRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// RequestDispatcher : jsp의 pageContext 역할
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/productReg.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		logger.info("::: %%%%%% :::\n{}", req);

		TblProductDao dao = new TblProductDao();
		int result = dao.insert(new ProductVo(
			req.getParameter("pcode"),
			req.getParameter("category"),
			req.getParameter("pname"),
			Integer.parseInt(req.getParameter("price"))
		));
		
		String message;
		if (result > 0) {
			message = "상품 등록이 완료되었습니다.";
			// resp.sendRedirect("products.cc");
		} else {
			message = "상품 등록 오류가 생겼습니다.";
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		out.print("alert('" + message + "');");
		out.print("location.href='products.cc';");
		out.print("</script>");
	}
}
