package day5.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.CategoryDto;
import day4.mybatis.dto.ProductDto;

@WebServlet(urlPatterns = {"/search.cc"}, description = "상품 검색")
public class productSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String column = req.getParameter("column");
		String desc = req.getParameter("desc");
		
		Map<String, Object> map = new HashMap<>();
		if (category != null && category.isEmpty() == false) {
			map.put("category", category);
			req.setAttribute("category", category);
		}
		if (keyword != null && keyword.isEmpty() == false) {
			map.put("keyword", keyword);
			req.setAttribute("keyword", keyword);
		}
		if (
			from != null && from.isEmpty() == false &&
			to != null && to.isEmpty() == false
		) {
			map.put("from", from);
			map.put("to", to);
		}
		if (column != null && column.isEmpty() == false) {
			map.put("column", column);
			
			if (desc != null && desc.equals("desc")) {
				map.put("desc", desc);
			}
		}

		MybatisProductDao dao = new MybatisProductDao();
		
		List<ProductDto> list = dao.search(map);
		req.setAttribute("list", list);

		List<CategoryDto> categoryList = dao.selectCategory();
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/day5/search.jsp");
		dispatcher.forward(req, resp);
	}
}
