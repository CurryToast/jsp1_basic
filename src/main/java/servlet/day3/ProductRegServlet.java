package servlet.day3;

import java.io.IOException;

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/productReg.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		logger.info("::: %%%%%% :::\n{}", req);

		TblProductDao dao = new TblProductDao();
		int result = dao.addProduct(new ProductVo(
			req.getParameter("pcode"),
			req.getParameter("category"),
			req.getParameter("pname"),
			Integer.parseInt(req.getParameter("price"))
		));
		
		if (result > 0) {
			resp.sendRedirect("products.cc");
		}
	}
}
