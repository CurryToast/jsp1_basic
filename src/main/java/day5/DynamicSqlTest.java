package day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public final class DynamicSqlTest {
	public static void main(String[] args) {
//		testNoFilter();
//		testCategoryFilter();
//		testKeywordFilter();
//		testKeywordAndCategoryFilter();
//		testPriceRangeFilter();
//		testAllFilter();
		testOrderBy();
	}
	
	public static void testNoFilter() {
		MybatisProductDao dao = new MybatisProductDao();

		List<ProductDto> list = dao.search(null);
		System.out.println("검색 필터 없음 : " + list);
	}
	
	public static void testCategoryFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("category", "A1"); // key는 파라미터 이름, value는 검색하고 싶은 컬럼값

		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 - 카테고리 : " + list);
	}
	
	public static void testKeywordFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", "사과");

		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 - 키워드 : " + list);
	}
	
	public static void testKeywordAndCategoryFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("category", "A1");
		map.put("keyword", "사과");

		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 - 키워드, 카테고리 : " + list);
	}
	
	public static void testPriceRangeFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("from", 10000);
		map.put("to", 50000);

		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 - 가격 범위 : " + list);
	}
	
	public static void testAllFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("category", "A1");
		map.put("keyword", "사과");
		map.put("from", 10000);
		map.put("to", 80000);

		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 - 전부 : " + list);
	}
	
	public static void testOrderBy() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("column", "category");

		List<ProductDto> list = dao.search(map);
		System.out.println("오름차순 정렬 : " + list);
	}
}
